package com.wtsintegration.adsi.client;

import java.util.List;

import junit.framework.TestCase;

import com.wtsintegration.adsi.model.Drug;
import com.wtsintegration.adsi.model.Reaction;
import com.wtsintegration.openfda.model.FdaPatientDrugResponse;

import static org.mockito.Mockito.*;


/**
 * Created by zmelnick on 6/23/15.
 */
public class DrugClientTest extends TestCase {
    DrugClient client = new DrugClient();
    private static final Drug IBUPROFEN = new Drug("IBUPROFEN");
    private static final Reaction RHINORRHOEA = new Reaction("RHINORRHOEA");

    public void setUp() throws Exception {
        super.setUp();
      //  client = new DrugClient();
    }

    public void tearDown() throws Exception {
        //client = null;
    }

    public void testGetCountAllRecords() throws Exception {
        Integer count = client.getCountAllRecords();
        assertNotNull(count);
        assertTrue(count > -1);
    }

    public void testGetCountByDrug() throws Exception {
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
        Integer count;

        count = client.getCountByReaction(RHINORRHOEA);
        assertNotNull(count);
        assertTrue(count > -1);

        count = client.getCountByReaction("XXXXX");
        assertNotNull(count);
        assertTrue(count == 0);

    }

    public void testGetCountByReaction1() throws Exception {
        Integer count;

        count = client.getCountByReaction(RHINORRHOEA.getPreferredTerm());
        assertNotNull(count);
        assertTrue(count > -1);

        count = client.getCountByReaction("XXXXX");
        assertNotNull(count);
        assertTrue(count == 0);
    }

    public void testGetCountByDrugAndReaction() throws Exception {
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
        List<Drug> drugs;

        drugs = client.getTopDrugs(10);
        assertNotNull(drugs);
        assertTrue(drugs.size() == 10);

        drugs = client.getTopDrugs(-1);
        assertNotNull(drugs);
        assertTrue(drugs.size() == 0);

    }

    public void testGetTopReactions() throws Exception {
        List<Reaction> reaction;

        reaction = client.getTopReactions(10);
        assertNotNull(reaction);
        assertTrue(reaction.size() == 10);

        reaction = client.getTopReactions(-1);
        assertNotNull(reaction);
        assertTrue(reaction.size() == 0);
    }

    public void testGetCountByDrugExcludeReaction() throws Exception {
        DrugClient spy = spy(client);
        final Integer COUNT_BY_DRUG = 100;
        final Integer COUNT_BY_DRUG_AND_REACTION = 10;

        when(spy.getCountByDrug(IBUPROFEN.getName())).thenReturn(COUNT_BY_DRUG);
        when(spy.getCountByDrugAndReaction(IBUPROFEN.getName(), RHINORRHOEA.getPreferredTerm()))
                .thenReturn(COUNT_BY_DRUG_AND_REACTION);
        int count = spy.getCountByDrugExcludeReaction(IBUPROFEN, RHINORRHOEA);
        assertNotNull(count);
        assertEquals(COUNT_BY_DRUG - COUNT_BY_DRUG_AND_REACTION, count);

        count = client.getCountByDrugExcludeReaction("XXXXX", "XXXXX");
        assertNotNull(count);
        assertTrue(count == 0);

    }

    public void testGetCountByDrugExcludeReaction1() throws Exception {
        DrugClient client = new DrugClient();
        DrugClient spy = spy(client);
        final Integer COUNT_BY_DRUG = 100;
        final Integer COUNT_BY_DRUG_AND_REACTION = 10;

        when(spy.getCountByDrug(IBUPROFEN.getName())).thenReturn(COUNT_BY_DRUG);
        when(spy.getCountByDrugAndReaction(IBUPROFEN.getName(), RHINORRHOEA.getPreferredTerm()))
                .thenReturn(COUNT_BY_DRUG_AND_REACTION);

        int count = spy.getCountByDrugExcludeReaction(IBUPROFEN.getName(), RHINORRHOEA.getPreferredTerm());
        assertNotNull(count);
        assertEquals(COUNT_BY_DRUG - COUNT_BY_DRUG_AND_REACTION, count);

        count = client.getCountByDrugExcludeReaction("XXXXX", "XXXXX");
        assertNotNull(count);
        assertTrue(count == 0);

    }

    public void testGetCountByDrugExcludeReaction2() throws Exception {
        DrugClient spy = spy(client);
        final Integer COUNT_BY_DRUG = 100;
        final Integer COUNT_BY_DRUG_AND_REACTION = 10;

        when(spy.getCountByDrug(IBUPROFEN.getName())).thenReturn(COUNT_BY_DRUG);
        when(spy.getCountByDrugAndReaction(IBUPROFEN.getName(), RHINORRHOEA.getPreferredTerm()))
                .thenReturn(COUNT_BY_DRUG_AND_REACTION);

        int count = spy.getCountByDrugExcludeReaction(IBUPROFEN.getName(), RHINORRHOEA.getPreferredTerm(),
                COUNT_BY_DRUG_AND_REACTION);
        assertNotNull(count);
        assertEquals(COUNT_BY_DRUG - COUNT_BY_DRUG_AND_REACTION, count);

        count = client.getCountByDrugExcludeReaction("XXXXX", "XXXXX");
        assertNotNull(count);
        assertTrue(count == 0);

    }

    public void testGetCountByReactionExcludeDrug() throws Exception {
        DrugClient spy = spy(client);
        final Integer COUNT_BY_REACTION = 100;
        final Integer COUNT_BY_DRUG_AND_REACTION = 10;

        when(spy.getCountByReaction(RHINORRHOEA.getPreferredTerm())).thenReturn(COUNT_BY_REACTION);
        when(spy.getCountByDrugAndReaction(IBUPROFEN.getName(), RHINORRHOEA.getPreferredTerm()))
                .thenReturn(COUNT_BY_DRUG_AND_REACTION);
        int count = spy.getCountByReactionExcludeDrug(RHINORRHOEA, IBUPROFEN);
        assertNotNull(count);
        assertEquals(COUNT_BY_REACTION - COUNT_BY_DRUG_AND_REACTION, count);

        count = client.getCountByReactionExcludeDrug("XXXXX", "XXXXX");
        assertNotNull(count);
        assertTrue(count == 0);
    }

    public void testGetCountByReactionExcludeDrug1() throws Exception {
        DrugClient spy = spy(client);
        final Integer COUNT_BY_REACTION = 100;
        final Integer COUNT_BY_DRUG_AND_REACTION = 10;

        when(spy.getCountByReaction(RHINORRHOEA.getPreferredTerm())).thenReturn(COUNT_BY_REACTION);
        when(spy.getCountByDrugAndReaction(IBUPROFEN.getName(), RHINORRHOEA.getPreferredTerm()))
                .thenReturn(COUNT_BY_DRUG_AND_REACTION);
        int count = spy.getCountByReactionExcludeDrug(RHINORRHOEA.getPreferredTerm(), IBUPROFEN.getName());
        assertNotNull(count);
        assertEquals(COUNT_BY_REACTION - COUNT_BY_DRUG_AND_REACTION, count);

        count = client.getCountByReactionExcludeDrug("XXXXX", "XXXXX");
        assertNotNull(count);
        assertTrue(count == 0);

    }

    public void testGetCountByReactionExcludeDrug2() throws Exception {
        DrugClient spy = spy(client);
        final Integer COUNT_BY_REACTION = 100;
        final Integer COUNT_BY_DRUG_AND_REACTION = 10;

        when(spy.getCountByReaction(RHINORRHOEA.getPreferredTerm())).thenReturn(COUNT_BY_REACTION);
        when(spy.getCountByDrugAndReaction(IBUPROFEN.getName(), RHINORRHOEA.getPreferredTerm()))
                .thenReturn(COUNT_BY_DRUG_AND_REACTION);
        int count = spy.getCountByReactionExcludeDrug(RHINORRHOEA.getPreferredTerm(), IBUPROFEN.getName(),
                COUNT_BY_DRUG_AND_REACTION);
        assertNotNull(count);
        assertEquals(COUNT_BY_REACTION - COUNT_BY_DRUG_AND_REACTION, count);

        count = client.getCountByReactionExcludeDrug("XXXXX", "XXXXX");
        assertNotNull(count);
        assertTrue(count == 0);

    }

    public void testGetCountExcludeDrugAndReaction() throws Exception {
        DrugClient spy = spy(client);
        final Integer total = 1000;
        final Integer totalForDrug = 100;
        final Integer totalForReaction = 90;
        final Integer totalForDrugAndReaction = 10;

        when(spy.getCountAllRecords()).thenReturn(total);
        when(spy.getCountByDrugAndReaction(IBUPROFEN.getName(), RHINORRHOEA.getPreferredTerm()))
                .thenReturn(totalForDrugAndReaction);
        when(spy.getCountByDrugExcludeReaction(IBUPROFEN.getName(), RHINORRHOEA.getPreferredTerm(),
                totalForDrugAndReaction)).thenReturn(totalForDrug);
        when(spy.getCountByReactionExcludeDrug(RHINORRHOEA.getPreferredTerm(), IBUPROFEN.getName(),
                totalForDrugAndReaction)).thenReturn(totalForReaction);

        int count = spy.getCountExcludeDrugAndReaction(IBUPROFEN, RHINORRHOEA);
        assertNotNull(count);
        assertEquals((total - (totalForDrug + totalForReaction + totalForDrugAndReaction)), count);

        count = client.getCountExcludeDrugAndReaction("XXXXX", "XXXXX");
        assertNotNull(count);
        assertEquals(Integer.valueOf(count), client.getCountAllRecords());
    }

    public void testGetCountExcludeDrugAndReaction1() throws Exception {
    	DrugClient spy = spy(client);
        final Integer total = 1000;
        final Integer totalForDrug = 100;
        final Integer totalForReaction = 90;
        final Integer totalForDrugAndReaction = 10;
        when(spy.getCountAllRecords()).thenReturn(total);
        when(spy.getCountByDrugAndReaction(IBUPROFEN.getName(), RHINORRHOEA.getPreferredTerm()))
                .thenReturn(totalForDrugAndReaction);
        when(spy.getCountByDrugExcludeReaction(IBUPROFEN.getName(), RHINORRHOEA.getPreferredTerm(),
                totalForDrugAndReaction)).thenReturn(totalForDrug);
        when(spy.getCountByReactionExcludeDrug(RHINORRHOEA.getPreferredTerm(), IBUPROFEN.getName(),
                totalForDrugAndReaction)).thenReturn(totalForReaction);

        int count = spy.getCountExcludeDrugAndReaction(IBUPROFEN.getName(), RHINORRHOEA.getPreferredTerm());
        assertNotNull(count);
        assertEquals((total - (totalForDrug + totalForReaction + totalForDrugAndReaction)), count);

        count = client.getCountExcludeDrugAndReaction("XXXXX", "XXXXX");
        assertNotNull(count);
        assertEquals(Integer.valueOf(count), client.getCountAllRecords());

    }

    public void testGetPatientDrugAndReactionList() {
        FdaPatientDrugResponse fdaResponse = client.getPatientDrugAndReactionList("LETAIRIS", "Rhinorrhoea");
        assertNotNull(fdaResponse);

    }

}