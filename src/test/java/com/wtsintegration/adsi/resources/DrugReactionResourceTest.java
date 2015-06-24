package com.wtsintegration.adsi.resources;

import com.wtsintegration.adsi.client.DrugClient;
import com.wtsintegration.adsi.model.Drug;
import com.wtsintegration.adsi.model.Reaction;
import junit.framework.TestCase;

/**
 * Created by zmelnick on 6/24/15.
 */
public class DrugReactionResourceTest extends TestCase {

    private DrugReactionResource resource = new DrugReactionResource();

    private static final Drug IBUPROFEN = new Drug("IBUPROFEN");
    private static final Reaction RHINORRHOEA = new Reaction("RHINORRHOEA");

    public void setUp() throws Exception {
       // super.setUp();
       // resource = new DrugReactionResource();
    }

    public void tearDown() throws Exception {
        //resource = null;
    }

    public void testGetAllDrugs() throws Exception {
       assertEquals(DrugReactionResource.DRUG_NUM, resource.getAllDrugs().size());
    }

    public void testGetAllReactions() throws Exception {
        assertEquals(DrugReactionResource.REACTION_NUM, resource.getAllReactions().size());
    }

    public void testGetCorrelation() throws Exception {

    }

    public void testGetReactionsForDrug() throws Exception {
        assertEquals(DrugReactionResource.TEN, resource.getReactionsForDrug(IBUPROFEN.getName()).size());

    }

    public void testGetCorrelationReport() throws Exception {

    }
}