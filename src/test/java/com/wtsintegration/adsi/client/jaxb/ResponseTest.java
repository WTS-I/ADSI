package com.wtsintegration.adsi.client.jaxb;

import junit.framework.TestCase;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zmelnick on 6/23/15.
 */
public class ResponseTest extends TestCase {
    Response response;

    public void setUp() throws Exception {
        super.setUp();
        response = new Response();
    }

    public void tearDown() throws Exception {
        response = null;
    }

    public void testGetMeta() throws Exception {
        Meta meta = new Meta();
        meta.setLicense("license");
        response.setMeta(meta);
        assertTrue(meta == response.getMeta());
    }

    public void testSetMeta() throws Exception {
        Meta meta = new Meta();
        meta.setLicense("license");
        response.setMeta(meta);
        assertTrue(meta == response.getMeta());
    }

    public void testGetResults() throws Exception {
        List<Result> resultList = new ArrayList<>();
        response.setResults(resultList);
        assertTrue(resultList == response.getResults());
    }

    public void testSetResults() throws Exception {
        List<Result> resultList = new ArrayList<>();
        response.setResults(resultList);
        assertTrue(resultList == response.getResults());
    }
}