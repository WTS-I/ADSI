package com.wtsintegration.adsi.resources;

import javax.ws.rs.WebApplicationException;

import junit.framework.TestCase;

import com.wtsintegration.adsi.model.Drug;
import com.wtsintegration.adsi.model.Reaction;

/**
 * Created by zmelnick on 6/24/15.
 */
public class DrugReactionResourceTest extends TestCase {

    private DrugReactionResource resource = new DrugReactionResource();

    private static final Drug IBUPROFEN = new Drug("IBUPROFEN");
    private static final Reaction RHINORRHOEA = new Reaction("RHINORRHOEA");

    public void setUp() throws Exception {
        super.setUp();
        resource = new DrugReactionResource();
    }

    public void tearDown() throws Exception {
        resource = null;
    }

    public void testGetAllDrugs() throws Exception {
       assertEquals(DrugReactionResource.DRUG_NUM, resource.getAllDrugs().size());
    }

    public void testGetAllReactions() throws Exception {
        assertEquals(DrugReactionResource.REACTION_NUM, resource.getAllReactions().size());
    }
    
    public void testGetCorrelation()  throws Exception {
    	try {
    		String correlation = resource.getCorrelation(IBUPROFEN.getName(), RHINORRHOEA.getPreferredTerm());
    		assertNotNull(correlation);
    	} catch (Exception e) {
    		assertEquals(e.getClass(), WebApplicationException.class);
    	}
    	
    	try {
    		String correlation = resource.getCorrelation(null, RHINORRHOEA.getPreferredTerm());
    		assertNotNull(correlation);
    	} catch (Exception e) {
    		assertEquals(e.getClass(), WebApplicationException.class);
    	}
    	
    	try {
    		String correlation = resource.getCorrelation(IBUPROFEN.getName(), null);
    		assertNotNull(correlation);
    	} catch (Exception e) {
    		assertEquals(e.getClass(), WebApplicationException.class);
    	}
    	
    }
    
    public void testGetReactionsForDrug()  throws Exception {
    	try {
    		String correlation = resource.getReactionsForDrug(IBUPROFEN.getName());
    		assertNotNull(correlation);
    	} catch (Exception e) {
    		assertEquals(e.getClass(), WebApplicationException.class);
    	}
    	
    	try {
    		String correlation = resource.getReactionsForDrug(null);
    		assertNotNull(correlation);
    	} catch (Exception e) {
    		assertEquals(e.getClass(), WebApplicationException.class);
    	}
    }
    
    public void testGetDrugsForReaction()  throws Exception {
    	try {
    		String correlation = resource.getDrugsForReaction(RHINORRHOEA.getPreferredTerm());
    		assertNotNull(correlation);
    	} catch (Exception e) {
    		assertEquals(e.getClass(), WebApplicationException.class);
    	}
    	
    	try {
    		String correlation = resource.getDrugsForReaction(null);
    		assertNotNull(correlation);
    	} catch (Exception e) {
    		assertEquals(e.getClass(), WebApplicationException.class);
    	}
    }
    
    public void testGetCorrelationReport()  throws Exception {
    	try {
    		String correlation = resource.getCorrelationReport(IBUPROFEN.getName(), RHINORRHOEA.getPreferredTerm());
    		assertNotNull(correlation);
    	} catch (Exception e) {
    		assertEquals(e.getClass(), WebApplicationException.class);
    	}
    	
    	try {
    		String correlation = resource.getCorrelationReport(null, RHINORRHOEA.getPreferredTerm());
    		assertNotNull(correlation);
    	} catch (Exception e) {
    		assertEquals(e.getClass(), WebApplicationException.class);
    	}
    	
    	try {
    		String correlation = resource.getCorrelationReport(IBUPROFEN.getName(), null);
    		assertNotNull(correlation);
    	} catch (Exception e) {
    		assertEquals(e.getClass(), WebApplicationException.class);
    	}
    }
}