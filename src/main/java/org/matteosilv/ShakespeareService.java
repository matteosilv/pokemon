package org.matteosilv;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * Client for pokeapi.co API v2.
 */
@Path("/shakespeare.json")
@RegisterRestClient(configKey = "shakespeare")
public interface ShakespeareService {

    @GET
    Translation translate(@QueryParam("text") String text);
}
