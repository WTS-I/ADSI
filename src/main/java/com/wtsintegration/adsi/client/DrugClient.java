package com.wtsintegration.adsi.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.glassfish.jersey.jackson.JacksonFeature;

import com.wtsintegration.adsi.client.jaxb.Response;
import com.wtsintegration.adsi.client.jaxb.Result;
import com.wtsintegration.adsi.model.Drug;
import com.wtsintegration.adsi.model.Reaction;
import com.wtsintegration.adsi.util.UserInterfaceAdapter;
import com.wtsintegration.openfda.model.FdaPatientDrugResponse;
import com.wtsintegration.openfda.model.FdaPatientDrugResult;

public enum DrugClient {
	INSTANCE;
	
	private static final Logger log = Logger.getLogger(DrugClient.class);
	
	private WebTarget webTarget;

	private final static String HOST = "https://api.fda.gov";
	private final static String PATH = "drug/event.json";
	
	DrugClient() {
		webTarget = ClientBuilder.newClient().target(HOST);
	}
	
	public Integer getCountAllRecords() {
		
		Response response = webTarget
				.path(PATH)
				.queryParam("search", "")
				.queryParam("limit", "1")
				.request(MediaType.TEXT_PLAIN_TYPE)
		        .get(Response.class);
		
		if (response != null && response.getMeta() != null && response.getMeta().getResults() != null) {
			return Integer.valueOf(response.getMeta().getResults().getTotal());
		}
		
		return null;
	}
	
	public Integer getCountByDrug(Drug drug) {
		return getCountByDrug(drug.getName());
	}
	
	public Integer getCountByDrug(String drug) {
		Response response = null;
		
		try {
			response = webTarget
					.path(PATH)
					.queryParam("search", "patient.drug.medicinalproduct:" + drug)
					.queryParam("limit", "1")
					.request(MediaType.TEXT_PLAIN_TYPE)
			        .get(Response.class);
		} catch (NotFoundException nfe) {
			return 0;
		} catch (Exception e) {
			System.out.println("DrugClient.getCountByDrug: " + e.getMessage());
		}
		
		if (response != null && response.getMeta() != null && response.getMeta().getResults() != null) {
			return Integer.valueOf(response.getMeta().getResults().getTotal());
		}
		
		return null;
	}
	
	public Integer getCountByReaction(Reaction reaction) {
		return getCountByReaction(reaction.getPreferredTerm());
	}
	
	public Integer getCountByReaction(String reaction) {
		Response response = null;
		
		try {
			response = webTarget
					.path(PATH)
					.queryParam("search", "patient.reaction.reactionmeddrapt:" + reaction)
					.queryParam("limit", "1")
					.request(MediaType.TEXT_PLAIN_TYPE)
			        .get(Response.class);
		} catch (NotFoundException nfe) {
			return 0;
		} catch (Exception e) {
			System.out.println("DrugClient.getCountByReaction: " + e.getMessage());
		}
		
		if (response != null && response.getMeta() != null && response.getMeta().getResults() != null) {
			return Integer.valueOf(response.getMeta().getResults().getTotal());
		}
		
		return null;
	}
	
	public Integer getCountByDrugAndReaction(Drug drug, Reaction reaction) {
		return getCountByDrugAndReaction(drug.getName(), reaction.getPreferredTerm());
	}
	
	public Integer getCountByDrugAndReaction(String drug, String reaction) {
		Response response = null;
		
		try {
			String searchParam = "patient.drug.medicinalproduct:" + drug
					+ " AND patient.reaction.reactionmeddrapt:" + reaction;
			
			response = webTarget
					.path(PATH)
					.queryParam("search", searchParam)
					.queryParam("limit", "1")
					.request(MediaType.TEXT_PLAIN_TYPE)
			        .get(Response.class);
		} catch (NotFoundException nfe) {
			return 0;
		} catch (Exception e) {
			System.out.println("DrugClient.getCountByDrugAndReaction: " + e.getMessage());
		}
		
		if (response != null && response.getMeta() != null && response.getMeta().getResults() != null) {
			return Integer.valueOf(response.getMeta().getResults().getTotal());
		}
		
		return null;
	}
	
	public List<Drug> getTopDrugs(int n) {
		Response response = null;
		List<Drug> drugs = new ArrayList<Drug>();
		
		try {
			response = webTarget
					.path(PATH)
					.queryParam("count", "patient.drug.medicinalproduct.exact")
					.queryParam("limit", String.valueOf(n))
					.request(MediaType.TEXT_PLAIN_TYPE)
			        .get(Response.class);
		} catch (NotFoundException nfe) {
			return drugs;
		} catch (Exception e) {
			System.out.println("DrugClient.getTopDrugs: " + e.getMessage());
		}
		
		if (response != null && response.getResults() != null) {
			for (Result result : response.getResults()) {
				drugs.add(new Drug(result.getTerm()));
			}
		}
		
		return drugs;
	}
	
	public List<Reaction> getTopReactions(int n) {
		Response response = null;
		List<Reaction> reactions = new ArrayList<Reaction>();
		
		try {
			response = webTarget
					.path(PATH)
					.queryParam("count", "patient.reaction.reactionmeddrapt.exact")
					.queryParam("limit", String.valueOf(n))
					.request(MediaType.TEXT_PLAIN_TYPE)
			        .get(Response.class);
		} catch (NotFoundException nfe) {
			return reactions;
		} catch (Exception e) {
			System.out.println("DrugClient.getTopReactions: " + e.getMessage());
		}
		
		if (response != null && response.getResults() != null) {
			for (Result result : response.getResults()) {
				reactions.add(new Reaction(result.getTerm()));
			}
		}
		
		return reactions;
	}
	
	public Integer getCountByDrugExcludeReaction(Drug drug, Reaction reaction) {
		return getCountByDrugExcludeReaction(drug.getName(), reaction.getPreferredTerm());
	}
	
	public Integer getCountByDrugExcludeReaction(String drug, String reaction) {
		
		Integer totalForDrug = getCountByDrug(drug);
		Integer totalForDrugAndReaction = getCountByDrugAndReaction(drug, reaction);
		if (totalForDrug != null && totalForDrugAndReaction != null) {
			return totalForDrug - totalForDrugAndReaction;
		} else {
			return null;
		}
	}
	
	public Integer getCountByDrugExcludeReaction(String drug, String reaction, Integer totalForDrugAndReaction) {
		
		Integer totalForDrug = getCountByDrug(drug);
		if (totalForDrug != null && totalForDrugAndReaction != null) {
			return totalForDrug - totalForDrugAndReaction;
		} else {
			return null;
		}
	}
	
	public Integer getCountByReactionExcludeDrug(Reaction reaction, Drug drug) {
		return getCountByReactionExcludeDrug(reaction.getPreferredTerm(), drug.getName());
	}
	
	public Integer getCountByReactionExcludeDrug(String reaction, String drug) {
		
		Integer totalForReaction = getCountByReaction(reaction);
		Integer totalForDrugAndReaction = getCountByDrugAndReaction(drug, reaction);
		if (totalForReaction != null && totalForDrugAndReaction != null) {
			return totalForReaction - totalForDrugAndReaction;
		} else {
			return null;
		}
	}
	
	public Integer getCountByReactionExcludeDrug(String reaction, String drug, Integer totalForDrugAndReaction) {
		
		Integer totalForReaction = getCountByReaction(reaction);
		if (totalForReaction != null && totalForDrugAndReaction != null) {
			return totalForReaction - totalForDrugAndReaction;
		} else {
			return null;
		}
	}
	
	public Integer getCountExcludeDrugAndReaction(Drug drug, Reaction reaction) {
		return getCountExcludeDrugAndReaction(drug.getName(), reaction.getPreferredTerm());
	}
	
	public Integer getCountExcludeDrugAndReaction(String drug, String reaction) {
		
		Integer total = getCountAllRecords();
		Integer totalForDrugAndReaction = getCountByDrugAndReaction(drug, reaction);
		Integer totalForDrug = getCountByDrugExcludeReaction(drug, reaction, totalForDrugAndReaction);
		Integer totalForReaction = getCountByReactionExcludeDrug(reaction, drug, totalForDrugAndReaction);
		
		if (total != null && totalForDrug != null && totalForReaction != null && totalForDrugAndReaction != null) {
			return total - (totalForDrug + totalForReaction + totalForDrugAndReaction);
		} else {
			return null;
		}
	}
	
	public FdaPatientDrugResponse getPatientDrugAndReactionList(String drug, String reaction) {
		
		javax.ws.rs.core.Response response = null;
		
		Client client = ClientBuilder.newClient().register(JacksonFeature.class);
		
		drug = "\"" + drug + "\"";
		reaction = "\"" + reaction + "\"";
		
		try {
			String searchParam = "patient.drug.medicinalproduct:" + drug
					+ " AND patient.reaction.reactionmeddrapt:" + reaction;
			
			StringBuffer stringBufferUrl = new StringBuffer();
			stringBufferUrl.append(PATH);
			stringBufferUrl.append("?search=");
			stringBufferUrl.append(searchParam);
			
//			WebTarget webTarget = client.target(stringBufferUrl.toString());
		
			WebTarget webTarget = client.target(HOST).path(PATH)
					.queryParam("search", searchParam).queryParam("limit", "100");
			
			//create the invocation object
			Invocation getInvocation =
					webTarget.request(MediaType.APPLICATION_JSON).buildGet();
			
			//call the FDA webservice
			response = getInvocation.invoke();
			
			log.debug("Response code = " + response.getStatus());

			//check the response code
			if (response.getStatus() != 200) {// 200 is successful GET response code
				log.error("getPatientDrugAndReactionList() Failed : HTTP error code : "
						+ response.getStatus());
				throw new Exception(
						"getPatientDrugAndReactionList() Failed : HTTP error code : "
								+ response.getStatus());
			}
			
			//use Jackson to convert the JSON response to an FdaPatientDrugResponse pojo
			FdaPatientDrugResponse fdaPatientDrugResponse = response.readEntity(FdaPatientDrugResponse.class);
					
			return fdaPatientDrugResponse;
			
		} catch (NotFoundException nfe) {
			return null;
		} catch (Exception e) {
			System.out.println("DrugClient.getPatientDrugAndReactionList: " + e.getMessage());
		}
		
		return null;
	}
}
