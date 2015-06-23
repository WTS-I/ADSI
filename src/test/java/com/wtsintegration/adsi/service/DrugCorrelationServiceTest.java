package com.wtsintegration.adsi.service;

import java.math.BigDecimal;

import junit.framework.TestCase;

import com.wtsintegration.adsi.model.Drug;
import com.wtsintegration.adsi.model.DrugReactionCorrelation;
import com.wtsintegration.adsi.model.Reaction;

public class DrugCorrelationServiceTest extends TestCase {

	private static final Drug IBUPROFEN = new Drug("IBUPROFEN");
	private static final Reaction RHINORRHOEA = new Reaction("RHINORRHOEA");

	public void testGetROR() {
		DrugCorrelationService service = null;
		BigDecimal ror = null;
		
		service = new DrugCorrelationService(IBUPROFEN, RHINORRHOEA);
		ror = service.getROR();
		assertNotNull(ror);
		assertTrue(ror.compareTo(new BigDecimal(-1)) >= 0);
		
		service = new DrugCorrelationService(new Drug("XXXXX"), new Reaction("XXXXX"));
		ror = service.getROR();
		assertNull(ror);
	}
	
	public void testGetPRR() {
		DrugCorrelationService service = null;
		BigDecimal prr = null;
		
		service = new DrugCorrelationService(IBUPROFEN, RHINORRHOEA);
		prr = service.getPRR();
		assertNotNull(prr);
		assertTrue(prr.compareTo(new BigDecimal(-1)) >= 0);
		
		service = new DrugCorrelationService(new Drug("XXXXX"), new Reaction("XXXXX"));
		prr = service.getPRR();
		assertNull(prr);
	}
	
	public void testGetRRR() {
		DrugCorrelationService service = null;
		BigDecimal rrr = null;
		
		service = new DrugCorrelationService(IBUPROFEN, RHINORRHOEA);
		rrr = service.getRRR();
		assertNotNull(rrr);
		assertTrue(rrr.compareTo(new BigDecimal(-1)) >= 0);
		
		service = new DrugCorrelationService(new Drug("XXXXX"), new Reaction("XXXXX"));
		rrr = service.getRRR();
		assertNull(rrr);
	}
	
	public void testGenerateCorrelation() {
		DrugCorrelationService service = null;
		
		service = new DrugCorrelationService(IBUPROFEN, RHINORRHOEA);
		DrugReactionCorrelation correlation = service.generateCorrelation();
		
		assertNotNull(correlation.getDrug());
		assertNotNull(correlation.getReaction());
		assertNotNull(correlation.getProportionalReportingRatio());
		assertNotNull(correlation.getRelativeReportingRatio());
		assertNotNull(correlation.getReportingOddsRatio());
		
	}
}
