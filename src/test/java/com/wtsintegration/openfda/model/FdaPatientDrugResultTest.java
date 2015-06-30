package com.wtsintegration.openfda.model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class FdaPatientDrugResultTest extends TestCase {

	FdaPatientDrugResult result;

	public void setUp() throws Exception {
		super.setUp();
		result = new FdaPatientDrugResult();

	}

	public void tearDown() throws Exception {
		result = null;
	}

	public void testGetPatient() throws Exception {
        FdaPatient patient = new FdaPatient();
        ArrayList<FdaReaction> list = new ArrayList<FdaReaction>();
		list.add(new FdaReaction());
		patient.setReaction(list);
		
		ArrayList<FdaDrug> list2 = new ArrayList<FdaDrug>();
		list2.add(new FdaDrug());
		patient.setDrug(list2);
		
		patient.setPatientsex("1");
		
        result.setPatient(patient);
        assertEquals(patient.getDrug().size(), result.getPatient().getDrug().size());
        assertEquals(patient.getReaction().size(), result.getPatient().getReaction().size());
        assertEquals(patient.getPatientsex(), result.getPatient().getPatientsex());
    }

    public void testSetName() throws Exception {
    	FdaPatient patient = new FdaPatient();
        ArrayList<FdaReaction> list = new ArrayList<FdaReaction>();
		list.add(new FdaReaction());
		patient.setReaction(list);
		
		ArrayList<FdaDrug> list2 = new ArrayList<FdaDrug>();
		list2.add(new FdaDrug());
		patient.setDrug(list2);
		
		patient.setPatientsex("1");
		
        result.setPatient(patient);
        assertEquals(patient.getDrug().size(), result.getPatient().getDrug().size());
        assertEquals(patient.getReaction().size(), result.getPatient().getReaction().size());
        assertEquals(patient.getPatientsex(), result.getPatient().getPatientsex());
    }

    public void testToString() throws Exception {
    	String s = result.toString();
		assertNotNull(s);
		assertTrue(s.length() > 0);
    }
}
