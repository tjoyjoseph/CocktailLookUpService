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

    final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    @Cacheable("cocktailName")
    public Drinks getCocktails(String cocktailName) throws IOException {
    URL url = new URL(BASEURL+SEARCH_NAME+cocktailName);
    return objectMapper.readValue(url,Drinks.class);
    }
}
