package com.wtsintegration.adsi.client.jaxb;

import junit.framework.TestCase;

/**
 * Created by zmelnick on 6/23/15.
 */
public class MetaTest extends TestCase {
    Meta meta;

    public void setUp() throws Exception {
        super.setUp();
        meta = new Meta();

    }

    public void tearDown() throws Exception {
        meta = null;
    }

    public void testGetDisclaimer() throws Exception {
        String disclaimer = "disclaimer";
        meta.setDisclaimer(disclaimer);
        assertEquals(disclaimer, meta.getDisclaimer());
    }

    public void testSetDisclaimer() throws Exception {
        String disclaimer = "disclaimer";
        meta.setDisclaimer(disclaimer);
        assertEquals(disclaimer, meta.getDisclaimer());
    }

    public void testGetLicense() throws Exception {
        String license = "license";
        meta.setLicense(license);
        assertEquals(license, meta.getLicense());
    }

    public void testSetLicense() throws Exception {
        String license = "license";
        meta.setLicense(license);
        assertEquals(license, meta.getLicense());
    }

    public void testGetLast_updated() throws Exception {
        String lastUpdated = "lastUpdated";
        meta.setLast_updated(lastUpdated);
        assertEquals(lastUpdated, meta.getLast_updated());
    }

    public void testSetLast_updated() throws Exception {
        String lastUpdated = "lastUpdated";
        meta.setLast_updated(lastUpdated);
        assertEquals(lastUpdated, meta.getLast_updated());
    }

    public void testGetResults() throws Exception {
        MetaResults metaResults = new MetaResults();
        String limit = "limit";
        String skip = "skip";
        metaResults.setLimit(limit);
        metaResults.setSkip(skip);

        meta.setResults(metaResults);
        assertTrue(metaResults == meta.getResults());
    }

    public void testSetResults() throws Exception {
        MetaResults metaResults = new MetaResults();
        String limit = "limit";
        String skip = "skip";
        metaResults.setLimit(limit);
        metaResults.setSkip(skip);

        meta.setResults(metaResults);
        assertTrue(metaResults == meta.getResults());
    }
}