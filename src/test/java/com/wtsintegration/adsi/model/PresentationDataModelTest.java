package com.wtsintegration.adsi.model;

import java.util.ArrayList;
import java.util.HashMap;

import junit.framework.TestCase;

public class PresentationDataModelTest extends TestCase {

	PresentationDataModel model;

	public void setUp() throws Exception {
		super.setUp();
		model = new PresentationDataModel();

	}

	public void tearDown() throws Exception {
		model = null;
	}

	public void testGetPresentationDataRows() throws Exception {
		PresentationDataRow row1 = new PresentationDataRow();
		PresentationDataRow row2 = new PresentationDataRow();
		ArrayList<PresentationDataRow> list = new ArrayList<PresentationDataRow>();
		list.add(row1);
		list.add(row2);
		
		model.setPresentationDataRows(list);
        assertEquals(list.size(), model.getPresentationDataRows().size());
        assertEquals(list.get(0), model.getPresentationDataRows().get(0));
    }
	
	public void testSetPresentationDataRows() throws Exception {
		PresentationDataRow row1 = new PresentationDataRow();
		PresentationDataRow row2 = new PresentationDataRow();
		ArrayList<PresentationDataRow> list = new ArrayList<PresentationDataRow>();
		list.add(row1);
		list.add(row2);
		
		model.setPresentationDataRows(list);
        assertEquals(list.size(), model.getPresentationDataRows().size());
        assertEquals(list.get(0), model.getPresentationDataRows().get(0));
    }

	public void testToString() throws Exception {
		String s = model.toString();
		assertNotNull(s);
		assertTrue(s.equals(""));
		
		PresentationDataRow row1 = new PresentationDataRow();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("test", "value");
		row1.setPresentationRow(map);
		ArrayList<PresentationDataRow> list = new ArrayList<PresentationDataRow>();
		list.add(row1);
		model.setPresentationDataRows(list);
		
		String s2 = model.toString();
		assertNotNull(s2);
		assertFalse(s2.equals(""));
		assertTrue(s2.length() > 0);
	}
}
