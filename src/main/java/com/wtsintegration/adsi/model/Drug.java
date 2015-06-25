package com.wtsintegration.adsi.model;

public class Drug implements AdsiModelInterface {

	private String name;

	public Drug() { }
	
	public Drug(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}