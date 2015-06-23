package com.wtsintegration.adsi.util;

import java.util.ArrayList;
import java.util.HashMap;

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
}
