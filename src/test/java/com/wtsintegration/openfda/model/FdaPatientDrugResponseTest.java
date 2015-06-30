package com.wtsintegration.openfda.model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class FdaPatientDrugResponseTest extends TestCase {

	FdaPatientDrugResponse response;

	public void setUp() throws Exception {
		super.setUp();
		response = new FdaPatientDrugResponse();

	}

	public void tearDown() throws Exception {
		response = null;
	}

	public void testGetMeta() throws Exception {
        MetaData data = new MetaData();
        data.setDisclaimer("disclaimer");
        data.setLicense("license");
        data.setLast_updated("updated");
        response.setMeta(data);
        assertEquals(data.getDisclaimer(), response.getMeta().getDisclaimer());
        assertEquals(data.getLicense(), response.getMeta().getLicense());
        assertEquals(data.getLast_updated(), response.getMeta().getLast_updated());
    }

    public void testSetResults() throws Exception {
    	MetaData data = new MetaData();
        data.setDisclaimer("disclaimer");
        data.setLicense("license");
        data.setLast_updated("updated");
        response.setMeta(data);
        assertEquals(data.getDisclaimer(), response.getMeta().getDisclaimer());
        assertEquals(data.getLicense(), response.getMeta().getLicense());
        assertEquals(data.getLast_updated(), response.getMeta().getLast_updated());
    }
    
    public void testGetReaction() throws Exception {
		ArrayList<FdaPatientDrugResult> list = new ArrayList<FdaPatientDrugResult>();
		list.add(new FdaPatientDrugResult());
		response.setResults(list);
		assertEquals(list.size(), response.getResults().size());
	}
	
	public void testSetReaction() throws Exception {
		ArrayList<FdaPatientDrugResult> list = new ArrayList<FdaPatientDrugResult>();
		list.add(new FdaPatientDrugResult());
		response.setResults(list);
		assertEquals(list.size(), response.getResults().size());
	}

	public void testToString() throws Exception {
    	String s = response.toString();
		assertNotNull(s);
		assertTrue(s.length() > 0);
    }
}
