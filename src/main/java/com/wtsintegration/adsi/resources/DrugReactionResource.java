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
		DrugClient client = new DrugClient();
		return client.getTopDrugs(DRUG_NUM);
	}
	
	@GET
	@Path("/reactions")
	public List<Reaction> getAllReactions() {
		DrugClient client = new DrugClient();
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
	
	private static final List<Drug> DRUGS = new ArrayList<Drug>();
	private static final List<Reaction> REACTIONS = new ArrayList<Reaction>();
	
	private static final Drug IBUPROFEN = new Drug("IBUPROFEN");
	private static final Drug LORATADINE = new Drug("LORATADINE");
	private static final Drug ZAROXOLYN = new Drug("ZAROXOLYN");
	private static final Drug ERYTHROMYCIN = new Drug("ERYTHROMYCIN");
	private static final Drug ESOMEPRAZOLE = new Drug("ESOMEPRAZOLE");
	
	private static final Reaction RHINORRHOEA = new Reaction("RHINORRHOEA");
	private static final Reaction HEMOPTYSIS = new Reaction("HEMOPTYSIS");
	private static final Reaction ANAPHYLAXIS = new Reaction("ANAPHYLAXIS");
	private static final Reaction PRURITIS = new Reaction("PRURITIS");
	private static final Reaction EPISTAXIS = new Reaction("EPISTAXIS");
	
	static {
		DRUGS.add(IBUPROFEN);
		DRUGS.add(LORATADINE);
		DRUGS.add(ZAROXOLYN);
		DRUGS.add(ERYTHROMYCIN);
		DRUGS.add(ESOMEPRAZOLE);
		
		REACTIONS.add(RHINORRHOEA);
		REACTIONS.add(HEMOPTYSIS);
		REACTIONS.add(ANAPHYLAXIS);
		REACTIONS.add(PRURITIS);
		REACTIONS.add(EPISTAXIS);
	}
}