package com.wtsintegration.openfda.model;

import junit.framework.TestCase;

public class FdaDrugTest extends TestCase {
	
	FdaDrug fdaDrug;

	public void setUp() throws Exception {
		super.setUp();
		fdaDrug = new FdaDrug();

	}

	public void tearDown() throws Exception {
		fdaDrug = null;
	}

	public void testGetMedicinalproduct() throws Exception {
        String medicinalproduct = "medicinalproduct";
        fdaDrug.setMedicinalproduct(medicinalproduct);
        assertEquals(medicinalproduct, fdaDrug.getMedicinalproduct());
    }

    public void testSetMedicinalproduct() throws Exception {
        String medicinalproduct = "medicinalproduct";
        fdaDrug.setMedicinalproduct(medicinalproduct);
        assertEquals(medicinalproduct, fdaDrug.getMedicinalproduct());
    }
    
    public void testGetDrugindication() throws Exception {
        String drugindication = "drugindication";
        fdaDrug.setDrugindication(drugindication);
        assertEquals(drugindication, fdaDrug.getDrugindication());
    }

    public void testSetDrugindication() throws Exception {
        String drugindication = "drugindication";
        fdaDrug.setDrugindication(drugindication);
        assertEquals(drugindication, fdaDrug.getDrugindication());
    }
    
    public void testGetDrugdosagetext() throws Exception {
        String drugdosagetext = "drugdosagetext";
        fdaDrug.setDrugdosagetext(drugdosagetext);
        assertEquals(drugdosagetext, fdaDrug.getDrugdosagetext());
    }

    public void testSetDrugdosagetext() throws Exception {
        String drugdosagetext = "drugdosagetext";
        fdaDrug.setDrugdosagetext(drugdosagetext);
        assertEquals(drugdosagetext, fdaDrug.getDrugdosagetext());
    }
    
    public void testGetDrugdosageform() throws Exception {
        String drugdosageform = "drugdosageform";
        fdaDrug.setDrugdosageform(drugdosageform);
        assertEquals(drugdosageform, fdaDrug.getDrugdosageform());
    }

    public void testSetDrugdosageform() throws Exception {
        String drugdosageform = "drugdosageform";
        fdaDrug.setDrugdosageform(drugdosageform);
        assertEquals(drugdosageform, fdaDrug.getDrugdosageform());
    }
    
    public void testGetDrugcharacterization() throws Exception {
        String drugcharacterization = "drugcharacterization";
        fdaDrug.setDrugcharacterization(drugcharacterization);
        assertEquals(drugcharacterization, fdaDrug.getDrugcharacterization());
    }

    public void testSetDrugcharacterization() throws Exception {
        String drugcharacterization = "drugcharacterization";
        fdaDrug.setDrugcharacterization(drugcharacterization);
        assertEquals(drugcharacterization, fdaDrug.getDrugcharacterization());
    }
    
    public void testGetActiondrug() throws Exception {
        String actiondrug = "actiondrug";
        fdaDrug.setActiondrug(actiondrug);
        assertEquals(actiondrug, fdaDrug.getActiondrug());
    }

    public void testSetActiondrug() throws Exception {
        String actiondrug = "actiondrug";
        fdaDrug.setActiondrug(actiondrug);
        assertEquals(actiondrug, fdaDrug.getActiondrug());
    }
    
    public void testToString() throws Exception {
    	String s = fdaDrug.toString();
		assertNotNull(s);
		assertTrue(s.length() > 0);
    }
    
    public void testGetFormattedString() throws Exception {
    	String s = fdaDrug.getFormattedString();
		assertNotNull(s);
		assertTrue(s.length() > 0);
    }
    
}
