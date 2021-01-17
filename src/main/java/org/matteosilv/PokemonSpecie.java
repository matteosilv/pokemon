package org.matteosilv;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonSpecie {

    public String name;
    
    @JsonProperty("flavor_text_entries")
    public List<FlavorTextEntry> flavorTextEntries;

    public static class FlavorTextEntry {

        @JsonProperty("flavor_text")
        public String flavorText;
        public Language language;

        public String getFlavorText() {
            return flavorText;
        }
    }

    public static class Language {
        public String name;
    }
}
