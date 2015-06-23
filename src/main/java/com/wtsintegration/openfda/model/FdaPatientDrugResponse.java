package com.wtsintegration.openfda.model;

import java.util.*;

import org.codehaus.jackson.annotate.*;

/**
 * Calls used to represent the FDA patient and drug reaction JSON object
 * @author John Oo
 *
 */

@org.codehaus.jackson.annotate.JsonAutoDetect(value = org.codehaus.jackson.annotate.JsonMethod.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FdaPatientDrugResponse {
	
	@org.codehaus.jackson.annotate.JsonProperty
	private MetaData meta;
	
	@org.codehaus.jackson.annotate.JsonProperty
	private ArrayList<FdaPatientDrugResult> results;

	public MetaData getMeta() {
		return meta;
	}

	public void setMeta(MetaData meta) {
		this.meta = meta;
	}
	
	public ArrayList<FdaPatientDrugResult> getResults() {
		return results;
	}

	public void setResults(ArrayList<FdaPatientDrugResult> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "FdaPatientDrugResponse [meta=" + meta + ", results=" + results
				+ "]";
	}

}
