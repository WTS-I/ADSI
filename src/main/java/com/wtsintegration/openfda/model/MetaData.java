package com.wtsintegration.openfda.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Calls used to represent the FDA meta data JSON object
 * @author John Oo
 *
 */

@XmlRootElement
public class MetaData {
	
	private String disclaimer;
	private String license;
	private String last_updated;
	private MetaResults results;
	
	public String getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}
	public MetaResults getResults() {
		return results;
	}
	public void setResults(MetaResults results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "MetaData [disclaimer=" + disclaimer + ", license=" + license
				+ ", last_updated=" + last_updated + ", results=" + results
				+ "]";
	}
	
	
}
