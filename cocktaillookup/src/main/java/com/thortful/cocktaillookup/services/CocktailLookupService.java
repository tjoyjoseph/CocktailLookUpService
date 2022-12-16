package com.thortful.cocktaillookup.services;

import com.thortful.cocktaillookup.objects.Drinks;
import org.springframework.cache.annotation.Cacheable;

import java.io.IOException;


public interface CocktailLookupService {

    @Cacheable("cocktailName")
    Drinks getCocktails(String cocktailName) throws IOException;
}
