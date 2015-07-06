package com.wtsintegration.adsi.model;

import java.util.HashMap;

import junit.framework.TestCase;

public class PresentationDataRowTest extends TestCase {

	PresentationDataRow row;

	public void setUp() throws Exception {
		super.setUp();
		row = new PresentationDataRow();

	}

	public void tearDown() throws Exception {
		row = null;
	}

	public void testGetPresentationRow() throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("test", "value");
		row.setPresentationRow(map);
		
        assertEquals(row.getPresentationRow().size(), map.size());
        assertEquals(row.getPresentationRow().get("test"), map.get("test"));
    }
	
	public void testSetPresentationRow() throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("test", "value");
		row.setPresentationRow(map);
		
        assertEquals(row.getPresentationRow().size(), map.size());
        assertEquals(row.getPresentationRow().get("test"), map.get("test"));
    }
	
	public void testToString() throws Exception {
		String s = row.toString();
		assertNotNull(s);
		assertTrue(s.equals(""));
	}
	
	public void testToString1() throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		row.setPresentationRow(map);
		
		String s2 = row.toString();
		assertNotNull(s2);
		assertFalse(s2.equals(""));
		assertTrue(s2.length() > 0);
	}
	
	public void testToString2() throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("test", "value");
		row.setPresentationRow(map);
		
		String s2 = row.toString();
		assertNotNull(s2);
		assertFalse(s2.equals(""));
		assertTrue(s2.length() > 0);
	}
	
	public void testToString3() throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		row.setPresentationRow(map);
		String keys = "";
		
		String s2 = row.toString(keys);
		assertNotNull(s2);
		assertFalse(s2.equals(""));
		assertTrue(s2.length() > 0);
	}
	
	public void testToString4() throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("test", "value");
		row.setPresentationRow(map);
		String keys = "test";
		
		String s2 = row.toString(keys);
		assertNotNull(s2);
		assertFalse(s2.equals(""));
		assertTrue(s2.length() > 0);
	}
}
