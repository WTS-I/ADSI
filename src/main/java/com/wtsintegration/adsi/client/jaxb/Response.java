package com.wtsintegration.adsi.client.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;


public class Response {

	@XmlElement(required=true)
	private Meta meta;
	@XmlElement(required=true)
	private List<Result> results;

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}
}
