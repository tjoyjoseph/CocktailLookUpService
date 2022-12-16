package com.thortful.cocktaillookup;

import com.thortful.cocktaillookup.services.CocktailLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CocktailLookupController {

    @Autowired
    CocktailLookupService cocktailLookupService;

    @GetMapping("/getCocktail")
    public String getCocktail(@RequestParam(value = "name", defaultValue = "margarita") String cocktailName) {
        return cocktailLookupService.getCocktail(cocktailName);
    }
}
