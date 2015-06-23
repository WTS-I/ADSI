package com.wtsintegration.openfda.model;

import org.codehaus.jackson.annotate.*;

/**
 * Calls used to represent the FDA drug JSON object
 * @author John Oo
 *
 */
@org.codehaus.jackson.annotate.JsonAutoDetect(value = org.codehaus.jackson.annotate.JsonMethod.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FdaDrug {

	@org.codehaus.jackson.annotate.JsonProperty
	private String medicinalproduct;

	@org.codehaus.jackson.annotate.JsonProperty
	private String drugindication;

	@org.codehaus.jackson.annotate.JsonProperty
	private String drugdosagetext;

	@org.codehaus.jackson.annotate.JsonProperty
	private String drugdosageform;

	@org.codehaus.jackson.annotate.JsonProperty
	private String drugcharacterization;

	@org.codehaus.jackson.annotate.JsonProperty
	private String actiondrug;

	public String getMedicinalproduct() {
		return medicinalproduct;
	}

	public void setMedicinalproduct(String medicinalproduct) {
		this.medicinalproduct = medicinalproduct;
	}

	public String getDrugindication() {
		return drugindication;
	}

	public void setDrugindication(String drugindication) {
		this.drugindication = drugindication;
	}

	public String getDrugdosagetext() {
		return drugdosagetext;
	}

	public void setDrugdosagetext(String drugdosagetext) {
		this.drugdosagetext = drugdosagetext;
	}

	public String getDrugdosageform() {
		return drugdosageform;
	}

	public void setDrugdosageform(String drugdosageform) {
		this.drugdosageform = drugdosageform;
	}

	public String getDrugcharacterization() {
		return drugcharacterization;
	}

	public void setDrugcharacterization(String drugcharacterization) {
		this.drugcharacterization = drugcharacterization;
	}

	public String getActiondrug() {
		return actiondrug;
	}

	public void setActiondrug(String actiondrug) {
		this.actiondrug = actiondrug;
	}

	@Override
	public String toString() {
		return "FdaDrug [medicinalproduct=" + medicinalproduct
				+ ", drugindication=" + drugindication + ", drugdosagetext="
				+ drugdosagetext + ", drugdosageform=" + drugdosageform
				+ ", drugcharacterization=" + drugcharacterization
				+ ", actiondrug=" + actiondrug + "]";
	}
	
	public String getFormattedString() {
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append(medicinalproduct);
		stringBuffer.append(", ");
		
		return stringBuffer.toString();
	}



}
