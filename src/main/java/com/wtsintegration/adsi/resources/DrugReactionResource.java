package com.wtsintegration.adsi.resources;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;

import com.wtsintegration.adsi.model.Drug;
import com.wtsintegration.adsi.model.DrugReactionCorrelation;
import com.wtsintegration.adsi.model.Reaction;

@Path("/adsi/1.0/")
public class DrugReactionResource {

	@GET
	@Path("/drugs")
	public List<Drug> getAllDrugs() {
		return DRUGS;
	}
	
	@GET
	@Path("/reactions")
	public List<Reaction> getAllReactions() {
		return REACTIONS;
	}
	
	@GET
	@Path("/correlations")
	public DrugReactionCorrelation getCorrelation(@QueryParam("drug") String drug, @QueryParam("reaction") String reaction) {
		if(null == drug || null == reaction) {
			throw new WebApplicationException("Both drug and reaction query parameters must be present");
		}
		return new DrugReactionCorrelation(new Drug(drug), new Reaction(reaction), new BigDecimal("1.1"), new BigDecimal("1.7"), new BigDecimal("1.42"));
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