package org.matteosilv;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.matteosilv.PokemonSpecie.FlavorTextEntry;
import org.matteosilv.Translation.Contents;

@Singleton
public class ShakespeareanPokedex implements Pokedex {

    private final PokemonService pokemonService;
    private final ShakespeareService shakespeareService;

    @Inject
    public ShakespeareanPokedex(@RestClient PokemonService pokemonService, @RestClient ShakespeareService shakespeareService) {
        this.pokemonService = pokemonService;
        this.shakespeareService = shakespeareService;
    }

    @Override
    public Pokemon getByName(String name) {
        PokemonSpecie pokemonSpecie = pokemonService.getPokemonSpecieByName(name);

        return new Pokemon(pokemonSpecie.name,
                pokemonSpecie.flavorTextEntries.stream().filter(this::isEnglish).findFirst()
                .map(FlavorTextEntry::getFlavorText)
                .map(this::replaceNewlines)
                .map(shakespeareService::translate)
                .map(Translation::getContents)
                .map(Contents::getTranslated)
                . orElseThrow());
    }

    private boolean isEnglish(PokemonSpecie.FlavorTextEntry entry) {
        return "en".equals(entry.language.name);
    }

    private String replaceNewlines(String text) {
        return text.replaceAll("\\s", " ");
    }
}
