package com.wtsintegration.adsi.client.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;


public class Response {

	@XmlElement
	private Meta meta;
	@XmlElement
	private List<Result> results;

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
}
