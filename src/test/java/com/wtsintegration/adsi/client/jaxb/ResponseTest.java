package com.wtsintegration.adsi.client.jaxb;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.wtsintegration.adsi.client.jaxb.Response.ResultComparator;

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
        List<Result> resultList = new ArrayList<Result>();
        response.setResults(resultList);
        assertTrue(resultList == response.getResults());
    }

    public void testSetResults() throws Exception {
        List<Result> resultList = new ArrayList<Result>();
        response.setResults(resultList);
        assertTrue(resultList == response.getResults());
    }
    
    public void testResultsSortNull() throws Exception {
        response.setResults(null);
        assertNull(response.getResults());
    }
    
    public void testResultsSort() throws Exception {
        Result result1 = new Result();
        result1.setTerm("ZZZ");
        Result result2 = new Result();
        result2.setTerm("AAA");
        List<Result> list = new ArrayList<Result>();
        list.add(result1);
        list.add(result2);
        
        response.setResults(list);
        assertTrue(response.getResults().size() == 2);
        assertTrue(response.getResults().get(0).getTerm().equals("AAA"));
    }
}