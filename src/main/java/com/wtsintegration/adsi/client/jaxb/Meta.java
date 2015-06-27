package com.wtsintegration.adsi.client.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="meta")
@XmlAccessorType(XmlAccessType.FIELD)
public class Meta {

	@XmlElement
	private String disclaimer;
	@XmlElement
	private String license;
	@XmlElement
	private String last_updated;
	
	@XmlElement
	private MetaResults results;

	public Meta() {
		super();
	}

	public Strong getDisclaimer() {
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
}
