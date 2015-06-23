package com.wtsintegration.openfda.model;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Calls used to represent the result set of patients from FDA JSON object
 * @author John Oo
 *
 */

@org.codehaus.jackson.annotate.JsonAutoDetect(value = org.codehaus.jackson.annotate.JsonMethod.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FdaPatientDrugResult {
	
	@org.codehaus.jackson.annotate.JsonProperty
	private FdaPatient patient;

	public FdaPatient getPatient() {
		return patient;
	}

	public void setPatient(FdaPatient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "FdaPatientDrugResult [patient=" + patient + "]";
	}
	
}
