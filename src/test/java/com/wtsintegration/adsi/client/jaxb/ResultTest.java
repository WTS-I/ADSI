package com.wtsintegration.adsi.client.jaxb;

import junit.framework.TestCase;

/**
 * Created by zmelnick on 6/23/15.
 */
public class ResultTest extends TestCase {
    Result result;

    public void setUp() throws Exception {
        super.setUp();
        result = new Result();
    }

    public void tearDown() throws Exception {
        result = null;
    }

    public void testGetTerm() throws Exception {
        String term = "term";
        result.setTerm(term);
        assertEquals(term, result.getTerm());
    }

    public void testSetTerm() throws Exception {
        String term = "term";
        result.setTerm(term);
        assertEquals(term, result.getTerm());
    }

    public void testGetCount() throws Exception {
        String count = "count";
        result.setCount(count);
        assertEquals(count, result.getCount());
    }

    public void testSetCount() throws Exception {
        String count = "count";
        result.setCount(count);
        assertEquals(count, result.getCount());
    }
}