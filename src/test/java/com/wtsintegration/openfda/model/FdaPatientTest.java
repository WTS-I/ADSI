package com.wtsintegration.openfda.model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class FdaPatientTest extends TestCase {
	
	FdaPatient fdaPatient;

	public void setUp() throws Exception {
		super.setUp();
		fdaPatient = new FdaPatient();

	}

	public void tearDown() throws Exception {
		fdaPatient = null;
	}
	
	public void testGetReaction() throws Exception {
		ArrayList<FdaReaction> list = new ArrayList<FdaReaction>();
		list.add(new FdaReaction());
		fdaPatient.setReaction(list);
		assertEquals(list.size(), fdaPatient.getReaction().size());
	}
	
	public void testSetReaction() throws Exception {
		ArrayList<FdaReaction> list = new ArrayList<FdaReaction>();
		list.add(new FdaReaction());
		fdaPatient.setReaction(list);
		assertEquals(list.size(), fdaPatient.getReaction().size());
	}
	
	public void testGetDrug() throws Exception {
		ArrayList<FdaDrug> list = new ArrayList<FdaDrug>();
		list.add(new FdaDrug());
		fdaPatient.setDrug(list);
		assertEquals(list.size(), fdaPatient.getDrug().size());
	}
	
	public void testSetDrug() throws Exception {
		ArrayList<FdaDrug> list = new ArrayList<FdaDrug>();
		list.add(new FdaDrug());
		fdaPatient.setDrug(list);
		assertEquals(list.size(), fdaPatient.getDrug().size());
	}

	public void testGetPatientsex() throws Exception {
        String patientsex = "patientsex";
        fdaPatient.setPatientsex(patientsex);
        assertEquals(patientsex, fdaPatient.getPatientsex());
    }
	
    public void testSetPatientsex() throws Exception {
        String patientsex = "patientsex";
        fdaPatient.setPatientsex(patientsex);
        assertEquals(patientsex, fdaPatient.getPatientsex());
    }
    
    public void testGetPatientSexString() throws Exception {
        fdaPatient.setPatientsex(null);
        assertEquals("", fdaPatient.getPatientSexString());
    }
	
	public void testGetPatientSexString1() throws Exception {
        String patientsex = "1";
        fdaPatient.setPatientsex(patientsex);
        assertEquals("Male", fdaPatient.getPatientSexString());
    }
	
	public void testGetPatientSexString2() throws Exception {
        String patientsex = "2";
        fdaPatient.setPatientsex(patientsex);
        assertEquals("Female", fdaPatient.getPatientSexString());
    }
	
	public void testGetRecationString() throws Exception {
    	String s = fdaPatient.getRecationString();
		assertNotNull(s);
		assertEquals("", s);
    }
	
	public void testGetRecationString1() throws Exception {
		FdaReaction reaction = new FdaReaction();
		ArrayList<FdaReaction> list = new ArrayList<FdaReaction>();
		list.add(reaction);
		fdaPatient.setReaction(list);
		
    	String s = fdaPatient.getRecationString();
		assertNotNull(s);
		assertEquals("NONE", s);
    }
	
	public void testGetRecationString2() throws Exception {
		FdaReaction reaction = new FdaReaction();
		reaction.setReactionmeddrapt("rash");
		ArrayList<FdaReaction> list = new ArrayList<FdaReaction>();
		list.add(reaction);
		fdaPatient.setReaction(list);
		
    	String s = fdaPatient.getRecationString();
		assertNotNull(s);
		assertEquals("rash", s);
    }
	
	public void testGetDrugString() throws Exception {
    	String s = fdaPatient.getDrugsString();
		assertNotNull(s);
		assertEquals("", s);
    }
	
	public void testGetDrugString1() throws Exception {
		FdaDrug drug = new FdaDrug();
		ArrayList<FdaDrug> list = new ArrayList<FdaDrug>();
		list.add(drug);
		fdaPatient.setDrug(list);
		
    	String s = fdaPatient.getDrugsString();
		assertNotNull(s);
		assertEquals("NONE", s);
    }
	
	public void testGetDrugString2() throws Exception {
		FdaDrug drug = new FdaDrug();
		drug.setMedicinalproduct("advil");
		ArrayList<FdaDrug> list = new ArrayList<FdaDrug>();
		list.add(drug);
		fdaPatient.setDrug(list);
		
    	String s = fdaPatient.getDrugsString();
		assertNotNull(s);
		assertEquals("advil", s);
    }
	
	public void testToString() throws Exception {
    	String s = fdaPatient.toString();
		assertNotNull(s);
		assertTrue(s.length() > 0);
    }
}
