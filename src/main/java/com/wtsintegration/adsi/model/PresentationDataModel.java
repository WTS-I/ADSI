package com.wtsintegration.adsi.model;

import java.util.*;

/**
 * Calls used to represent the presentation data model. It consists of an ArrayList
 * of PresentationDataRow objects, each of which is a HashMap, that contains a set of keys
 * and corresponding values. i.e. drugs="LETAIRIS, ADCIRCA, REMODULIN" reactions="Oropharyngeal pain, Rhinorrhoea"
 * 
 * @author John Oo
 *
 */

public class PresentationDataModel {
	
	private ArrayList<PresentationDataRow> presentationDataRows;
	
	public ArrayList<PresentationDataRow> getPresentationDataRows() {
		return presentationDataRows;
	}

	public void setPresentationDataRows(
			ArrayList<PresentationDataRow> presentationDataRows) {
		this.presentationDataRows = presentationDataRows;
	}

	public String toString() {
		
		if(presentationDataRows == null) {
			return "";
		}
		
		//example		
		/*
		[
			[
			  "Male",
			  "Tylenol, Asperin",
			  "High blood pressure, dizziness, sweaty plams"
			],
			[
			  "Female",
			  "Tylenol",
			  "High blood pressure, sweaty plams"
			],
			[
			 "Female",
			  "Tylenol, Asperin",
			  "High blood pressure, dizziness"
			]
		]
		 
		 */
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("[\n");//start bracket
		
		//iterate through the values
		for(PresentationDataRow presentationDataRow : presentationDataRows) {
			stringBuffer.append(presentationDataRow.toString());
			stringBuffer.append(",\n");
			
		}
		
		//remove the last ',' comma from the string
		stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
			
		stringBuffer.append("\n]");//end bracket
		
		return stringBuffer.toString();
	}
}
