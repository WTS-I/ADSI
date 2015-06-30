package com.wtsintegration.adsi.util;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.wtsintegration.adsi.model.AdsiModelInterface;
import com.wtsintegration.adsi.model.Drug;
import com.wtsintegration.adsi.model.PresentationDataModel;
import com.wtsintegration.adsi.model.Reaction;
import com.wtsintegration.openfda.model.FdaDrug;
import com.wtsintegration.openfda.model.FdaPatient;
import com.wtsintegration.openfda.model.FdaPatientDrugResponse;
import com.wtsintegration.openfda.model.FdaPatientDrugResult;
import com.wtsintegration.openfda.model.FdaReaction;
import com.wtsintegration.openfda.model.MetaData;

public class UserInterfaceAdapterTest extends TestCase {


	public void setUp() throws Exception {
		super.setUp();

	}

	public void tearDown() throws Exception {
	}
	
	public void testCreatUiPresentationDataModel() throws Exception {
		FdaPatientDrugResponse response = new FdaPatientDrugResponse();
		MetaData data = new MetaData();
        data.setDisclaimer("disclaimer");
        data.setLicense("license");
        data.setLast_updated("updated");
        response.setMeta(data);
        
        FdaPatientDrugResult result = new FdaPatientDrugResult();
        FdaPatient patient = new FdaPatient();
        ArrayList<FdaReaction> list = new ArrayList<FdaReaction>();
        FdaReaction reaction = new FdaReaction();
        reaction.setReactionmeddrapt("Rash");
		list.add(reaction);
		patient.setReaction(list);
		ArrayList<FdaDrug> list2 = new ArrayList<FdaDrug>();
		FdaDrug drug = new FdaDrug();
		drug.setMedicinalproduct("Advil");
		list2.add(drug);
		patient.setDrug(list2);
		patient.setPatientsex("1");
        result.setPatient(patient);
        
        ArrayList<FdaPatientDrugResult> resultList = new ArrayList<FdaPatientDrugResult>();
        resultList.add(result);
        response.setResults(resultList);
        
        PresentationDataModel model = UserInterfaceAdapter.creatUiPresentationDataModel(response);
        String s = model.toString();
        assertNotNull(s);
		assertFalse(s.equals(""));
		assertTrue(s.length() > 0);
	}
	
	public void testConvertListToUiString() throws Exception {
		
		List<AdsiModelInterface> list = null;
		
		String s = UserInterfaceAdapter.convertListToUiString(list);
        assertNotNull(s);
		assertTrue(s.equals(""));
	}
	
	public void testConvertListToUiString1() throws Exception {
		
		List<AdsiModelInterface> list = new ArrayList<AdsiModelInterface>();
		
		String s = UserInterfaceAdapter.convertListToUiString(list);
        assertNotNull(s);
		assertFalse(s.equals(""));
		assertTrue(s.length() > 0);
	}
	
	public void testConvertListToUiString2() throws Exception {
		Drug drug = new Drug();
		drug.setName("Advil");
		Reaction reaction = new Reaction();
		reaction.setPreferredTerm("Rash");
		List<AdsiModelInterface> list = new ArrayList<AdsiModelInterface>();
		list.add(drug);
		list.add(reaction);
		
		String s = UserInterfaceAdapter.convertListToUiString(list);
        assertNotNull(s);
		assertFalse(s.equals(""));
		assertTrue(s.length() > 0);
	}

}
