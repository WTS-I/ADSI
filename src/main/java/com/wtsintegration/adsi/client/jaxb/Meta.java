package com.wtsintegration.adsi.client.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="meta")
@XmlAccessorType(XmlAccessType.FIELD)
public class Meta {

	@XmlElement
	String disclaimer;
	@XmlElement
	String license;
	@XmlElement
	String last_updated;
	
	@XmlElement
	private Result results;

	public Meta() {
		super();
	}

	public Result getResults() {
		return results;
	}

	public void setResults(Result results) {
		this.results = results;
	}
}
