package com.wtsintegration.adsi.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;

@Path("/resources")
public class JAXRSDoNothingResource {
	
	private static final JSONObject EMPTY = new JSONObject();
	
	@Context UriInfo context;
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public JSONObject get(@PathParam("id") String id){
		return EMPTY;
	}
}