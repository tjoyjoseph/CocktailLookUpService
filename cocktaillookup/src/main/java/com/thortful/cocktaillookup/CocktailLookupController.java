package com.thortful.cocktaillookup;

import com.thortful.cocktaillookup.services.CocktailLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class CocktailLookupController {

    @Autowired
    CocktailLookupService cocktailLookupService;

    @RequestMapping(value = "/getCocktail", method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCocktail(
            @RequestParam(value = "name", defaultValue = "margarita") String cocktailName){
        try {
            return new ResponseEntity<>(cocktailLookupService.getCocktails(cocktailName), HttpStatus.OK);
        }catch (IOException e){
            return new ResponseEntity<>("Something went wrong while attempting to connect to thecocktaildb.com", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
