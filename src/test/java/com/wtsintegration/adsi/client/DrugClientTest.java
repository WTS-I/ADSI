package com.wtsintegration.adsi.client;

import junit.framework.TestCase;

public class DrugClientTest extends TestCase {

	public void testGetCountAllRecords() {
		DrugClient client = new DrugClient();
		
		Integer count = client.getCountAllRecords();
		assertNotNull(count);
		assertTrue(count > -1);
	}
}
