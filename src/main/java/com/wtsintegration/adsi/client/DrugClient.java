package com.wtsintegration.adsi.client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.wtsintegration.adsi.client.jaxb.Response;

public class DrugClient {
	
	private WebTarget webTarget;

	private final static String HOST = "https://api.fda.gov";
	private final static String PATH = "drug/event.json";
	
	public DrugClient() {
		webTarget = ClientBuilder.newClient().target(HOST);
	}
	
	public Integer getCountAllRecords() {
		
		Response response = webTarget
				.path(PATH)
				.queryParam("search", "")
				.queryParam("limit", "1")
				.request(MediaType.TEXT_PLAIN_TYPE)
		        .get(Response.class);
		
		if (response != null && response.getMeta() != null && response.getMeta().getResults() != null) {
			return Integer.valueOf(response.getMeta().getResults().getTotal());
		}
		
		return null;
	}
}
