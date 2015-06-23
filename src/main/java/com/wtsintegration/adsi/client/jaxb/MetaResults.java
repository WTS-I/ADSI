package com.wtsintegration.adsi.client.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class MetaResults {

	@XmlElement
	private String skip;
	@XmlElement
	private String limit;
	@XmlElement
	private String total;

	public String getSkip() {
		return skip;
	}

	public void setSkip(String skip) {
		this.skip = skip;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

}
