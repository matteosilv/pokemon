package org.matteosilv;

/**
 * A Pokemon with a name and a description.
 */
public class Pokemon {

    private final String name;

    private final String description;

    public Pokemon(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Get the Pokemon name.
     * 
     * @return the Pokemon name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the Pokemon description.
     * 
     * @return the Pokemon description.
     */
    public String getDescription() {
        return description;
    }

}
