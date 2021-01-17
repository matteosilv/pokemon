package org.matteosilv;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pokemon")
public class PokemonResource {

    private final Pokedex pokedex;

    @Inject
    public PokemonResource(Pokedex pokedex) {
        this.pokedex = pokedex;
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pokemon getByName(@PathParam("name") String name) {
        return pokedex.getByName(name);
    }
}