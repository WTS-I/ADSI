package com.wtsintegration.adsi.client.jaxb;

import junit.framework.TestCase;

/**
 * Created by zmelnick on 6/23/15.
 */
public class MetaResultsTest extends TestCase {
    MetaResults metaResults;

    public void setUp() throws Exception {
        super.setUp();
        metaResults = new MetaResults();
    }

    public void tearDown() throws Exception {
        metaResults = null;

    }

    public void testGetSkip() throws Exception {
        String skip = "skip";
        metaResults.setSkip(skip);
        assertEquals(skip, metaResults.getSkip());
    }

    public void testSetSkip() throws Exception {
        String skip = "skip";
        metaResults.setSkip(skip);
        assertEquals(skip, metaResults.getSkip());
    }

    public void testGetLimit() throws Exception {
        String limit = "limit";
        metaResults.setLimit(limit);
        assertEquals(limit, metaResults.getLimit());
    }

    public void testSetLimit() throws Exception {
        String limit = "limit";
        metaResults.setLimit(limit);
        assertEquals(limit, metaResults.getLimit());
    }

    public void testGetTotal() throws Exception {
        String total = "total";
        metaResults.setTotal(total);
        assertEquals(total, metaResults.getTotal());
    }

    public void testSetTotal() throws Exception {
        String total = "total";
        metaResults.setTotal(total);
        assertEquals(total, metaResults.getTotal());
    }
}