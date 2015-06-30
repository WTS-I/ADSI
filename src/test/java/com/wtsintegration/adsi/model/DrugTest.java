package com.wtsintegration.adsi.model;

import junit.framework.TestCase;

public class DrugTest extends TestCase {

	Drug drug;

	public void setUp() throws Exception {
		super.setUp();
		drug = new Drug();

	}

	public void tearDown() throws Exception {
		drug = null;
	}

	public void testGetName() throws Exception {
        String name = "name";
        drug.setName(name);
        assertEquals(name, drug.getName());
    }

    public void testSetName() throws Exception {
        String name = "name";
        drug.setName(name);
        assertEquals(name, drug.getName());
    }
}
