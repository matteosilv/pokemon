package org.matteosilv;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * Client for pokeapi.co API v2.
 */
@Path("/v2")
@RegisterRestClient(configKey = "pokeapi.v2")
public interface PokemonService {

    @GET
    @Path("/pokemon-species/{name}")
    PokemonSpecie getPokemonSpecieByName(@PathParam("name") String name);

}
