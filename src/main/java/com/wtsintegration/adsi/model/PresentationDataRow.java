package com.wtsintegration.adsi.model;

import java.util.*;

/**
 * Calls used to represent the presentation row data model. It consists of 
 * a HashMap, that contains a set of keys and corresponding values. 
 * i.e. drugs="LETAIRIS, ADCIRCA, REMODULIN" reactions="Oropharyngeal pain, Rhinorrhoea"
 * 
 * @author John Oo
 *
 */
public class PresentationDataRow {
	
	private HashMap<String, String> presentationRow;

	public HashMap<String, String> getPresentationRow() {
		return presentationRow;
	}

	public void setPresentationRow(HashMap<String, String> presentationRow) {
		this.presentationRow = presentationRow;
	}
	
	public String toString(String keys) {
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("   [");//start bracket
		
		//iterate through the values
		StringTokenizer stringTokenizer = new StringTokenizer(keys, ",");
		
		while(stringTokenizer.hasMoreElements()) {
			String key = stringTokenizer.nextToken();
			stringBuffer.append("\n\t\"");
			System.out.println("key = " + key + "value = " + presentationRow.get(key));
			stringBuffer.append(presentationRow.get(key));
			stringBuffer.append("\",");			
		}
		
		//remove the last ',' comma from the string
		stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
			
		stringBuffer.append("\n   ]");//end bracket
		
		return stringBuffer.toString();
	}
	
	public String toString() {
		
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
		stringBuffer.append("   [");//start bracket
		
		//iterate through the values
		Set<String> keys = presentationRow.keySet();
		
//		//getting data from keys
//		for(String key : keys) {
//			stringBuffer.append("\n\t\"");
////			System.out.println("key = " + key + "value = " + presentationRow.get(key));
//			stringBuffer.append(presentationRow.get(key));
//			stringBuffer.append("\",");			
//		}
		
			stringBuffer.append("\n\t\"");
			stringBuffer.append(presentationRow.get("Patient Sex"));
			stringBuffer.append("\",");	
			
			stringBuffer.append("\n\t\"");
			stringBuffer.append(presentationRow.get("Drugs"));
			stringBuffer.append("\",");	
			
			stringBuffer.append("\n\t\"");
			stringBuffer.append(presentationRow.get("Reactions"));
			stringBuffer.append("\",");	
		
		//remove the last ',' comma from the string
		stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
			
		stringBuffer.append("\n   ]");//end bracket
		
		return stringBuffer.toString();
		
//		return null;
	}
}
