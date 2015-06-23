package com.wtsintegration.adsi.client;

import java.util.List;

import junit.framework.TestCase;

import com.wtsintegration.adsi.model.Drug;
import com.wtsintegration.adsi.model.Reaction;

public class DrugClientTest extends TestCase {

	private static final Drug IBUPROFEN = new Drug("IBUPROFEN");
	private static final Reaction RHINORRHOEA = new Reaction("RHINORRHOEA");
	
	public void testGetCountAllRecords() {
		DrugClient client = new DrugClient();
		
		Integer count = client.getCountAllRecords();
		assertNotNull(count);
		assertTrue(count > -1);
	}
	
	public void testGetCountByDrug() {
		DrugClient client = new DrugClient();
		Integer count = null;
		
		count = client.getCountByDrug(IBUPROFEN);
		assertNotNull(count);
		assertTrue(count > -1);
		
		count = client.getCountByDrug("XXXXX");
		assertNotNull(count);
		assertTrue(count == 0);
	}
	
	public void testGetCountByReaction() {
		DrugClient client = new DrugClient();
		Integer count = null;
		
		count = client.getCountByReaction(RHINORRHOEA);
		assertNotNull(count);
		assertTrue(count > -1);
		
		count = client.getCountByReaction("XXXXX");
		assertNotNull(count);
		assertTrue(count == 0);
	}
	
	public void testGetCountByDrugAndReaction() {
		DrugClient client = new DrugClient();
		Integer count = null;
		
		count = client.getCountByDrugAndReaction(IBUPROFEN, RHINORRHOEA);
		assertNotNull(count);
		assertTrue(count > -1);
		
		count = client.getCountByDrugAndReaction("XXXXX", "XXXXX");
		assertNotNull(count);
		assertTrue(count == 0);
	}
	
	public void testGetCountByDrugExcludeReaction() {
		DrugClient client = new DrugClient();
		Integer count = null;
		
		count = client.getCountByDrugExcludeReaction(IBUPROFEN, RHINORRHOEA);
		assertNotNull(count);
		assertTrue(count > -1);
		
		count = client.getCountByDrugExcludeReaction("XXXXX", "XXXXX");
		assertNotNull(count);
		assertTrue(count == 0);
	}
	
	public void testGetCountByReactionExcludeDrug() {
		DrugClient client = new DrugClient();
		Integer count = null;
		
		count = client.getCountByReactionExcludeDrug(RHINORRHOEA, IBUPROFEN);
		assertNotNull(count);
		assertTrue(count > -1);
		
		count = client.getCountByReactionExcludeDrug("XXXXX", "XXXXX");
		assertNotNull(count);
		assertTrue(count == 0);
	}
	
	public void testGetCountExcludeDrugAndReaction() {
		DrugClient client = new DrugClient();
		Integer count = null;
		
		count = client.getCountExcludeDrugAndReaction(IBUPROFEN, RHINORRHOEA);
		assertNotNull(count);
		assertTrue(count > -1);
		
		count = client.getCountExcludeDrugAndReaction("XXXXX", "XXXXX");
		assertNotNull(count);
		assertTrue(count.equals(client.getCountAllRecords()));
	}
	
	public void testGetTopDrugs() {
		DrugClient client = new DrugClient();
		List<Drug> drugs = null;
		
		drugs = client.getTopDrugs(10);
		assertNotNull(drugs);
		assertTrue(drugs.size() == 10);
		
		drugs = client.getTopDrugs(-1);
		assertNotNull(drugs);
		assertTrue(drugs.size() == 0);
	}
	
	public void testGetTopReactions() {
		DrugClient client = new DrugClient();
		List<Reaction> reaction = null;
		
		reaction = client.getTopReactions(10);
		assertNotNull(reaction);
		assertTrue(reaction.size() == 10);
		
		reaction = client.getTopReactions(-1);
		assertNotNull(reaction);
		assertTrue(reaction.size() == 0);
	}
}
