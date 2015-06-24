package com.wtsintegration.adsi.client.jaxb;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;


public class Response {

	@XmlElement
	private Meta meta;
	@XmlElement
	private List<Result> results;

	//ADSI-31, ADSI-32, alphabetize Drugs/Reactions list
	class ResultComparator implements Comparator<Result> {
		  @Override
		  public int compare(Result result1, Result result2) {
			  return result1.getTerm().compareTo(result2.getTerm());
		  }
	}
	

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public List<Result> getResults() {
		if(results!=null){
			Collections.sort(results, new ResultComparator());
		}
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
}
