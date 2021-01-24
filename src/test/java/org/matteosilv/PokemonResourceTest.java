package org.matteosilv;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PokemonResourceTest {

    @Test
    public void testQueryingExistingPokemon() {
        given()
          .when().get("/pokemon/bulbasaur")
          .then()
             .statusCode(200).body("name", is("bulbasaur"))
             .body("description", is("A strange seed wast planted on its back at birth. The plant sprouts and grows with this pokémon."));
    }

    @Test
    public void testQueryingNotExistingPokemon() {
        given()
                .when().get("/pokemon/fake")
                .then()
                .statusCode(404);
    }


    @Test
    public void testQueryingWithInvalidParameters() {
        given()
                .when().get("/pokemon/0")
                .then()
                .statusCode(400);
    }
}