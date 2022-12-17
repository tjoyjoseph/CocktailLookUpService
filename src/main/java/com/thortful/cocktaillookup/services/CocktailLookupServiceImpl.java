package com.thortful.cocktaillookup.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thortful.cocktaillookup.objects.Drinks;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

@Service
public class CocktailLookupServiceImpl implements CocktailLookupService{
    final String BASEURL = "https://www.thecocktaildb.com/api/json/v1/1/search.php?";
    final String SEARCH_NAME = "s=";
    final String SEARCH_LETTER = "f=";

    final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    @Cacheable("cocktailName")
    public Drinks getCocktails(String name) throws IOException {
        return getDrinks(SEARCH_NAME,name);
    }

    @Override
    @Cacheable("cocktailName")
    public Drinks getCocktailsFromLetter(String letter) throws IOException {
        return getDrinks(SEARCH_LETTER, String.valueOf(letter));
    }

    private Drinks getDrinks(String searchCriteria, String value) throws IOException {
        URL url = new URL(BASEURL+searchCriteria+value);
        Drinks drinks = objectMapper.readValue(url,Drinks.class);
        return drinks;
    }
}
