package com.thortful.cocktaillookup.services;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Objects;

@Service
public class CocktailLookupServiceImpl implements CocktailLookupService{
    final String BASEURL = "https://www.thecocktaildb.com/api/json/v1/1/search.php?";
    final String SEARCH_NAME = "s=";
    @Override
    @Cacheable("cocktailName")
    public String getCocktail(String cocktailName){

        try {
            URL url = new URL(BASEURL+SEARCH_NAME+cocktailName);
            String result = IOUtils.toString(url, StandardCharsets.UTF_8);
            LinkedHashMap<String, Object> cocktailDbObj = new JSONParser(result).object();
            String drinks = String.valueOf(cocktailDbObj.get("drinks"));

            if(Objects.equals(drinks, "null")) {
                return "No results";
            }else{
                return drinks;
            }

        }catch (IOException exception){
            return "Cannot connect to thecocktaildb.com";
        } catch (ParseException e) {
            return "Could not read value from thecocktaildb.com";
        }

    }
}
