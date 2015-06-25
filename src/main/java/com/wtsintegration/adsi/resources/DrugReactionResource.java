package com.wtsintegration.adsi.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;

import com.wtsintegration.adsi.client.DrugClient;
import com.wtsintegration.adsi.model.Drug;
import com.wtsintegration.adsi.model.DrugReactionCorrelation;
import com.wtsintegration.adsi.model.Reaction;
import com.wtsintegration.adsi.service.DrugCorrelationService;
import com.wtsintegration.adsi.util.UserInterfaceAdapter;
import com.wtsintegration.openfda.model.FdaPatientDrugResponse;

@Path("/adsi/1.0")
public class DrugReactionResource {
	
	protected static final int DRUG_NUM = 100;
	protected static final int REACTION_NUM = 100;
	protected static final int TEN = 10;

	private static final DrugClient INSTANCE = new DrugClient();

	@GET
	@Path("/drugs")
	public List<Drug> getAllDrugs() {
		DrugClient client = new DrugClient();
		return client.getTopDrugs(DRUG_NUM);
	}
	
	@GET
	@Path("/reactions")
	public List<Reaction> getAllReactions() {
		DrugClient client = new DrugClient();
		return client.getTopReactions(REACTION_NUM);
	}
	
	/**
	 * Returns a JSON string format of the drug reaction correlation:: drug name, reaction rrr, prr, and ror
	 * @param drug
	 * @param reaction
	 * @return String drug name, reaction, RRR, PRR, ROR
	 */
	@GET
	@Path("/correlations")
	public String getCorrelation(@QueryParam("drug") String drug, @QueryParam("reaction") String reaction) {
		if(null == drug || null == reaction) {
			throw new WebApplicationException("Both drug and reaction query parameters must be present");
		}
		DrugReactionCorrelation correlation = new DrugCorrelationService(new Drug(drug), new Reaction(reaction)).generateCorrelation();
		return correlation.toString();
	}
	
	@GET
	@Path("/reactionsForDrug")
	public String getReactionsForDrug(@QueryParam("drug") String drug) {
		if(null == drug) {
			throw new WebApplicationException("drug query parameter must be present");
		}
		List<Reaction> reactions = INSTANCE.getTopReactionsByDrug(new Drug(drug), TEN);
		return UserInterfaceAdapter.convertReactionListToUiString(reactions);
	}
	
	@GET
	@Path("/topDrugByReaction")
	public String getDrugsForReaction(@QueryParam("reaction") String reaction) {
		if(null == reaction) {
			throw new WebApplicationException("drug query parameter must be present");
		}
		List<Drug> drugs = INSTANCE.getTopDrugByReaction(new Reaction(reaction), TEN);
		return drugs.toString();
		//return UserInterfaceAdapter.convertReac;ionListToUiString(reactions);
	}

	/**
	 * gets a drug and reaction report of up to 100 records
	 * @param drug - name of drug
	 * @param reaction - name of reaction
	 * @return String that the UI is expecting
	 */
	@GET
	@Path("/correlationsReport")
	public String getCorrelationReport(@QueryParam("drug") String drug, @QueryParam("reaction") String reaction) {
		if(null == drug || null == reaction) {
			throw new WebApplicationException("Both drug and reaction query parameters must be present");
		}

		DrugClient fdaRestService = new DrugClient();

		FdaPatientDrugResponse fdaResponse = fdaRestService.getPatientDrugAndReactionList(drug, reaction);

		return UserInterfaceAdapter.creatUiPresentationDataModel(fdaResponse).toString();
	}

}