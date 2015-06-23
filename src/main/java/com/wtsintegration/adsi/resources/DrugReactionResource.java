package com.wtsintegration.adsi.resources;

import java.util.ArrayList;
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

@Path("/adsi/1.0")
public class DrugReactionResource {
	
	private static final int DRUG_NUM = 100;
	private static final int REACTION_NUM = 100;

	@GET
	@Path("/drugs")
	public List<Drug> getAllDrugs() {
		DrugClient client = DrugClient.INSTANCE;
		return client.getTopDrugs(DRUG_NUM);
	}
	
	@GET
	@Path("/reactions")
	public List<Reaction> getAllReactions() {
		DrugClient client = DrugClient.INSTANCE;
		return client.getTopReactions(REACTION_NUM);
	}
	
	@GET
	@Path("/correlations")
	public DrugReactionCorrelation getCorrelation(@QueryParam("drug") String drug, @QueryParam("reaction") String reaction) {
		if(null == drug || null == reaction) {
			throw new WebApplicationException("Both drug and reaction query parameters must be present");
		}
		DrugReactionCorrelation correlation = new DrugCorrelationService(new Drug(drug), new Reaction(reaction)).generateCorrelation();
		return correlation;
	}
	
	@GET
	@Path("/reactionsForDrug")
	public List<Reaction> getReactionsForDrug(@QueryParam("drug") String drug) {
		if(null == drug) {
			throw new WebApplicationException("drug query parameter must be present");
		}
		List<Reaction> reactions = DrugClient.INSTANCE.getTopReactionsByDrug(new Drug(drug), 10);
		return reactions;
	}
}