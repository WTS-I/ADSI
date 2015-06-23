package com.wtsintegration.openfda.model;

import org.codehaus.jackson.annotate.*;

import java.util.*;

/**
 * Calls used to represent the FDA patient JSON object
 * @author John Oo
 *
 */

@org.codehaus.jackson.annotate.JsonAutoDetect(value = org.codehaus.jackson.annotate.JsonMethod.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FdaPatient {
	
	@org.codehaus.jackson.annotate.JsonProperty
	private ArrayList<FdaReaction> reaction;
	
	@org.codehaus.jackson.annotate.JsonProperty
	private ArrayList<FdaDrug> drug;
	
	@org.codehaus.jackson.annotate.JsonProperty
	private String patientsex;

	public ArrayList<FdaReaction> getReaction() {
		return reaction;
	}

	public void setReaction(ArrayList<FdaReaction> reaction) {
		this.reaction = reaction;
	}

	public ArrayList<FdaDrug> getDrug() {
		return drug;
	}

	public void setDrug(ArrayList<FdaDrug> drug) {
		this.drug = drug;
	}

	public String getPatientsex() {
		return patientsex;
	}

	public void setPatientsex(String patientsex) {
		this.patientsex = patientsex;
	}
	
	public String getPatientSexString() {
		if (patientsex == null) {
			return "";
		}
		else {
			if("1".equals(patientsex)) {
				return "Male";
			}
			else {
				return "Female";
			}
		}
	}
	
	public String getRecationString() {
		if(reaction == null) {
			return "";
		}
		StringBuffer stringBuffer = new StringBuffer();
		
		for(FdaReaction fdaReaction : reaction) {
			if(fdaReaction.getReactionmeddrapt() == null) {
				stringBuffer.append("NONE");
			}
			else {
				stringBuffer.append(fdaReaction.getReactionmeddrapt());
			}
			stringBuffer.append(", ");
		}
		
		//remove the last ', ' comma from the string
		stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
		
		return stringBuffer.toString();
	}
	
	public String getDrugsString() {
		
		if(drug == null) {
			return "";
		}
		StringBuffer stringBuffer = new StringBuffer();
		
		for(FdaDrug fdaDrug : drug) {
			if(fdaDrug.getMedicinalproduct() == null) {
				stringBuffer.append("NONE");
			}
			else {
				stringBuffer.append(fdaDrug.getMedicinalproduct());
			}
			stringBuffer.append(", ");
		}
		
		//remove the last ', ' comma from the string
		stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
		
		return stringBuffer.toString();
	}

	@Override
	public String toString() {
		return "FdaPatient [reaction=" + reaction + ", drug=" + drug
				+ ", patientsex=" + patientsex + "]";
	}	
	
}