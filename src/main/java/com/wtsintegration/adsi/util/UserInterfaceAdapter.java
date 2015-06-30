package com.wtsintegration.adsi.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.wtsintegration.openfda.model.FdaPatient;
import com.wtsintegration.openfda.model.FdaPatientDrugResponse;
import com.wtsintegration.openfda.model.FdaPatientDrugResult;
import com.wtsintegration.adsi.model.*;

/**
 * User Interface adaper class used to convert the FDA models into the String
 * the UI expects for display purposes.
 * 
 * @author John Oo
 *
 */

public class UserInterfaceAdapter {

	/**
	 * Creates PresentationDataModel from the incoming FdaPatientDrugResponse object
	 * @param fdaPatientDrugResponse
	 * @return
	 */
	public static PresentationDataModel creatUiPresentationDataModel(FdaPatientDrugResponse fdaPatientDrugResponse) {
		
		PresentationDataModel presentationDataModel = new PresentationDataModel();
		ArrayList<PresentationDataRow> presentationDataRows = new ArrayList<PresentationDataRow>(100);
		
		//iterate through the FdaPatientDrugResponse and create a presentation layer model
		for(FdaPatientDrugResult fdaPatientDrugResult : fdaPatientDrugResponse.getResults()) {		
			
			FdaPatient fdaPatient = fdaPatientDrugResult.getPatient();
			
			if(fdaPatient != null) { //make sure the patient object exists!
				PresentationDataRow presentationDataRow = new PresentationDataRow();
				
				HashMap<String, String> row = new HashMap<String, String>();
				
				row.put("Reactions", fdaPatient.getRecationString());
				row.put("Drugs", fdaPatient.getDrugsString());
				row.put("Patient Sex", fdaPatient.getPatientSexString());
				
				presentationDataRow.setPresentationRow(row);
				
				presentationDataRows.add(presentationDataRow);
			}
		}
		
		presentationDataModel.setPresentationDataRows(presentationDataRows);
		
		return presentationDataModel;
	}
	
	/**
	 * Creates a UI for the presentation layer string from incoming Reaction array
	 * @param list ArrayList of reactions or drugs
	 * @return String 
	 */
	public static String convertListToUiString(List<AdsiModelInterface> list) {
		
		if (list == null) {
			return "";
		}
		
		//example		
		/*
		
		{"draw":1,"recordedTotal":1,"recordsFiltered":1,"data":
			[
				[
				  "dizziness"
				],
				[
				  "cold sweats"
				],
				[
				  "vertigo"
				]
			]
		}
		 
		 */
		
		StringBuffer stringBuffer = new StringBuffer();
		
		int recordTotal = 0;
		
		if(list != null) {
			recordTotal = list.size();
		}
		
		//first brace
		stringBuffer.append("{\"draw\":1,\"recordedTotal\":" + recordTotal + ",\"recordsFiltered\":" + recordTotal + ",\"data\":\n");
		
		stringBuffer.append("[\t\n");//start bracket
		
		//iterate through the values
		for(AdsiModelInterface item : list) {
			stringBuffer.append("\t[");
			stringBuffer.append("\"");
			stringBuffer.append(item.getName());
			stringBuffer.append("\"");
			stringBuffer.append("],\n");	
		}
		
		//remove the last ',' comma from the string
		stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
			
		stringBuffer.append("\t\n]");//end bracket
		
		//end brace
		stringBuffer.append("\n}");
		
		return stringBuffer.toString();
	}
}
