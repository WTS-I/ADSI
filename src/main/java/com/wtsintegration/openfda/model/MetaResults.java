package com.wtsintegration.openfda.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Calls used to represent the FDA meta results JSON object
 * @author John Oo
 *
 */
@XmlRootElement
public class MetaResults {
	private String skip;
	private String limit;
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
	@Override
	public String toString() {
		return "MetaResults [skip=" + skip + ", limit=" + limit + ", total="
				+ total + "]";
	}
	
	
}
