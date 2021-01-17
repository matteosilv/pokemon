package org.matteosilv;

/**
 * Allows access to Pokemon information.
 */
public interface Pokedex {

    /**
     * Get a {@link Pokemon} by its name.
     * 
     * @param name the Pokemon name
     * @return the Pokemon
     */
    Pokemon getByName(String name);

}
