package com.wtsintegration.openfda.model;

import junit.framework.TestCase;

public class MetaDataTest extends TestCase {

	MetaData metaData;

	public void setUp() throws Exception {
		super.setUp();
		metaData = new MetaData();

	}

	public void tearDown() throws Exception {
		metaData = null;
	}

	public void testGetDisclaimer() throws Exception {
        String disclaimer = "disclaimer";
        metaData.setDisclaimer(disclaimer);
        assertEquals(disclaimer, metaData.getDisclaimer());
    }

    public void testSetDisclaimer() throws Exception {
        String disclaimer = "disclaimer";
        metaData.setDisclaimer(disclaimer);
        assertEquals(disclaimer, metaData.getDisclaimer());
    }
    
    public void testGetLicense() throws Exception {
        String license = "license";
        metaData.setLicense(license);
        assertEquals(license, metaData.getLicense());
    }

    public void testSetLicense() throws Exception {
        String license = "license";
        metaData.setLicense(license);
        assertEquals(license, metaData.getLicense());
    }
    
    public void testGetLast_updated() throws Exception {
        String last_updated = "last_updated";
        metaData.setLast_updated(last_updated);
        assertEquals(last_updated, metaData.getLast_updated());
    }

    public void testSetLast_updated() throws Exception {
        String last_updated = "last_updated";
        metaData.setLast_updated(last_updated);
        assertEquals(last_updated, metaData.getLast_updated());
    }
    
    public void testGetResults() throws Exception {
        MetaResults results = new MetaResults();
        results.setTotal("100");
        results.setLimit("10");
        results.setSkip("0");
        metaData.setResults(results);
        assertEquals(results.getTotal(), metaData.getResults().getTotal());
        assertEquals(results.getLimit(), metaData.getResults().getLimit());
        assertEquals(results.getSkip(), metaData.getResults().getSkip());
    }

    public void testSetResults() throws Exception {
    	MetaResults results = new MetaResults();
        results.setTotal("100");
        results.setLimit("10");
        results.setSkip("0");
        metaData.setResults(results);
        assertEquals(results.getTotal(), metaData.getResults().getTotal());
        assertEquals(results.getLimit(), metaData.getResults().getLimit());
        assertEquals(results.getSkip(), metaData.getResults().getSkip());
    }
    
    public void testToString() throws Exception {
    	String s = metaData.toString();
		assertNotNull(s);
		assertTrue(s.length() > 0);
    }
}
