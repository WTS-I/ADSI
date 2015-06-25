package com.wtsintegration.adsi.model;

public class Reaction implements AdsiModelInterface  {

	private String preferredTerm;

	public Reaction() { }
	
	public Reaction(String preferredTerm) {
		this.preferredTerm = preferredTerm;
	}
	
	public String getPreferredTerm() {
		return preferredTerm;
	}

	public void setPreferredTerm(String preferredTerm) {
		this.preferredTerm = preferredTerm;
	}

	public String getName() {
		return preferredTerm;
	}
	
	
}