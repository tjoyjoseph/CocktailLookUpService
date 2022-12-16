package com.thortful.cocktaillookup.services;

import com.thortful.cocktaillookup.objects.Drinks;

import java.io.IOException;


public interface CocktailLookupService {

    /**
     * The method will return all cocktails that contain the name
     * @param name - name of the cocktail
     * @return Drinks - cocktails that contains name
     * @throws IOException - if something goes wrong in the process for instance parsing the JSON, or reaching the service
     */
    Drinks getCocktails(String name) throws IOException;

    /**
     * The method will return all cocktails that start with the provided letter
     * @param letter - starting letter of the cocktail
     * @return Drinks = cocktails that start with letter
     * @throws IOException - if something goes wrong in the process for instance parsing the JSON, or reaching the service
     */
    Drinks getCocktailsFromLetter(String letter) throws IOException;
}
