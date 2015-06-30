package com.wtsintegration.adsi.model;

import java.math.BigDecimal;

import junit.framework.TestCase;

public class DrugRelationCorrelationTest extends TestCase {
	
	DrugReactionCorrelation drugRelationCorrelation;

	public void setUp() throws Exception {
		super.setUp();
		drugRelationCorrelation = new DrugReactionCorrelation();

	}

	public void tearDown() throws Exception {
		drugRelationCorrelation = null;
	}

	public void testGetDrug() throws Exception {
		Drug drug = new Drug("name");
		drugRelationCorrelation.setDrug(drug);
        assertEquals(drug, drugRelationCorrelation.getDrug());
	}

	public void testSetDrug() throws Exception {
		Drug drug = new Drug("name");
		drugRelationCorrelation.setDrug(drug);
        assertEquals(drug, drugRelationCorrelation.getDrug());
	}

	public void testGetReaction() throws Exception {
		Reaction reaction = new Reaction("term");
		drugRelationCorrelation.setReaction(reaction);
        assertEquals(reaction, drugRelationCorrelation.getReaction());
	}

	public void testSetReaction() throws Exception {
		Reaction reaction = new Reaction("term");
		drugRelationCorrelation.setReaction(reaction);
        assertEquals(reaction, drugRelationCorrelation.getReaction());
	}

	public void testGetTotal() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setTotal(bd);
        assertEquals(bd, drugRelationCorrelation.getTotal());
	}

	public void testSetTotal() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setTotal(bd);
        assertEquals(bd, drugRelationCorrelation.getTotal());
	}

	public void testGetTotalForDrug() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setTotalForDrug(bd);
        assertEquals(bd, drugRelationCorrelation.getTotalForDrug());
	}

	public void testSetTotalForDrug() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setTotalForDrug(bd);
        assertEquals(bd, drugRelationCorrelation.getTotalForDrug());
	}

	public void testGetTotalForReaction() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setTotalForReaction(bd);
        assertEquals(bd, drugRelationCorrelation.getTotalForReaction());
	}

	public void testSetTotalForReaction() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setTotalForReaction(bd);
        assertEquals(bd, drugRelationCorrelation.getTotalForReaction());
	}

	public void testGetTotalForDrugAndReaction() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setTotalForDrugAndReaction(bd);
        assertEquals(bd, drugRelationCorrelation.getTotalForDrugAndReaction());
	}

	public void testSetTotalForDrugAndReaction() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setTotalForDrugAndReaction(bd);
        assertEquals(bd, drugRelationCorrelation.getTotalForDrugAndReaction());
	}

	public void testGetTotalForDrugExcludeReaction() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setTotalForDrugExcludeReaction(bd);
        assertEquals(bd, drugRelationCorrelation.getTotalForDrugExcludeReaction());
	}

	public void testSetTotalForDrugExcludeReaction() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setTotalForDrugExcludeReaction(bd);
        assertEquals(bd, drugRelationCorrelation.getTotalForDrugExcludeReaction());
	}

	public void testGetTotalForReactionExcludeDrug() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setTotalForReactionExcludeDrug(bd);
        assertEquals(bd, drugRelationCorrelation.getTotalForReactionExcludeDrug());
	}

	public void testSetTotalForReactionExcludeDrug() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setTotalForReactionExcludeDrug(bd);
        assertEquals(bd, drugRelationCorrelation.getTotalForReactionExcludeDrug());
	}

	public void testGetTotalExcludeDrugAndReaction() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setTotalExcludeDrugAndReaction(bd);
        assertEquals(bd, drugRelationCorrelation.getTotalExcludeDrugAndReaction());
	}

	public void testSetTotalExcludeDrugAndReaction() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setTotalExcludeDrugAndReaction(bd);
        assertEquals(bd, drugRelationCorrelation.getTotalExcludeDrugAndReaction());
	}

	public void testGetReportingOddsRatio() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setReportingOddsRatio(bd);
        assertEquals(bd, drugRelationCorrelation.getReportingOddsRatio());
	}

	public void testSetReportingOddsRatio() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setReportingOddsRatio(bd);
        assertEquals(bd, drugRelationCorrelation.getReportingOddsRatio());
	}

	public void testGetProportionalReportingRatio() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setProportionalReportingRatio(bd);
        assertEquals(bd, drugRelationCorrelation.getProportionalReportingRatio());
	}

	public void testSetProportionalReportingRatio() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setProportionalReportingRatio(bd);
        assertEquals(bd, drugRelationCorrelation.getProportionalReportingRatio());
	}

	public void testGetRelativeReportingRatio() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setRelativeReportingRatio(bd);
        assertEquals(bd, drugRelationCorrelation.getRelativeReportingRatio());
	}

	public void testSetRelativeReportingRatio() throws Exception {
		BigDecimal bd = new BigDecimal(1.1);
		drugRelationCorrelation.setRelativeReportingRatio(bd);
        assertEquals(bd, drugRelationCorrelation.getRelativeReportingRatio());
	}
	
	public void testToString() throws Exception {
		Drug drug = new Drug("name");
		Reaction reaction = new Reaction("term");
		BigDecimal bd = new BigDecimal(1.1);
		
		drugRelationCorrelation.setDrug(drug);
		drugRelationCorrelation.setReaction(reaction);
		drugRelationCorrelation.setReportingOddsRatio(bd);
		drugRelationCorrelation.setProportionalReportingRatio(bd);
		drugRelationCorrelation.setRelativeReportingRatio(bd);
		
		String str = drugRelationCorrelation.toString();
		assertNotNull(str);
		assertTrue(str.length() > 0);
	}

}
