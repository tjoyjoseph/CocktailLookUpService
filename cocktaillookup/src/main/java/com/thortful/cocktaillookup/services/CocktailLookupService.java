package com.thortful.cocktaillookup.services;

import org.springframework.cache.annotation.Cacheable;


public interface CocktailLookupService {

    @Cacheable("cocktailName")
    String getCocktail(String cocktailName);
}
