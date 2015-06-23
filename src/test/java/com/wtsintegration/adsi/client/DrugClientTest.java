package com.wtsintegration.adsi.client;

import java.util.List;

import junit.framework.TestCase;

import com.wtsintegration.adsi.model.Drug;
import com.wtsintegration.adsi.model.Reaction;

/**
 * Created by zmelnick on 6/23/15.
 */
public class DrugClientTest extends TestCase {
    DrugClient client = DrugClient.INSTANCE;
    private static final Drug IBUPROFEN = new Drug("IBUPROFEN");
    private static final Reaction RHINORRHOEA = new Reaction("RHINORRHOEA");

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testGetCountAllRecords() throws Exception {
        Integer count = client.getCountAllRecords();
        assertNotNull(count);
        assertTrue(count > -1);
    }

    public void testGetCountByDrug() throws Exception {
        DrugClient client = DrugClient.INSTANCE;
        Integer count;

        count = client.getCountByDrug(IBUPROFEN);
        assertNotNull(count);
        assertTrue(count > -1);

        count = client.getCountByDrug("XXXXX");
        assertNotNull(count);
        assertTrue(count == 0);

    }

    public void testGetCountByDrug1() throws Exception {

    }

    public void testGetCountByReaction() throws Exception {
        DrugClient client = DrugClient.INSTANCE;
        Integer count;

        count = client.getCountByReaction(RHINORRHOEA);
        assertNotNull(count);
        assertTrue(count > -1);

        count = client.getCountByReaction("XXXXX");
        assertNotNull(count);
        assertTrue(count == 0);

    }

    public void testGetCountByReaction1() throws Exception {

    }

    public void testGetCountByDrugAndReaction() throws Exception {
        DrugClient client = DrugClient.INSTANCE;
        Integer count;

        count = client.getCountByDrugAndReaction(IBUPROFEN, RHINORRHOEA);
        assertNotNull(count);
        assertTrue(count > -1);

        count = client.getCountByDrugAndReaction("XXXXX", "XXXXX");
        assertNotNull(count);
        assertTrue(count == 0);

    }

    public void testGetCountByDrugAndReaction1() throws Exception {

    }

    public void testGetTopDrugs() throws Exception {

    }

    public void testGetTopReactions() throws Exception {

    }

    public void testGetCountByDrugExcludeReaction() throws Exception {
        DrugClient client = DrugClient.INSTANCE;
        Integer count;

        count = client.getCountByDrugExcludeReaction(IBUPROFEN, RHINORRHOEA);
        assertNotNull(count);
        assertTrue(count > -1);

        count = client.getCountByDrugExcludeReaction("XXXXX", "XXXXX");
        assertNotNull(count);
        assertTrue(count == 0);

    }

    public void testGetCountByDrugExcludeReaction1() throws Exception {

    }

    public void testGetCountByDrugExcludeReaction2() throws Exception {

    }

    public void testGetCountByReactionExcludeDrug() throws Exception {
        DrugClient client = DrugClient.INSTANCE;
        Integer count;

        count = client.getCountByReactionExcludeDrug(RHINORRHOEA, IBUPROFEN);
        assertNotNull(count);
        assertTrue(count > -1);

        count = client.getCountByReactionExcludeDrug("XXXXX", "XXXXX");
        assertNotNull(count);
        assertTrue(count == 0);

    }

    public void testGetCountByReactionExcludeDrug1() throws Exception {

    }

    public void testGetCountByReactionExcludeDrug2() throws Exception {

    }

    public void testGetCountExcludeDrugAndReaction() throws Exception {

    }

    public void testGetCountExcludeDrugAndReaction1() throws Exception {

    }
    
    public void testGetTopReactionsByDrug() throws Exception {
        DrugClient client = DrugClient.INSTANCE;
        List<Reaction> reactions;

        reactions = client.getTopReactionsByDrug(IBUPROFEN, 10);
        assertNotNull(reactions);
        assertTrue(reactions.size() == 10);

    }
    
    public void testGetTopReactionsByDrug1() throws Exception {
        DrugClient client = DrugClient.INSTANCE;
        List<Reaction> reactions;

        reactions = client.getTopReactionsByDrug("XXXXX", 10);
        assertNotNull(reactions);
        assertTrue(reactions.size() == 0);

    }
}