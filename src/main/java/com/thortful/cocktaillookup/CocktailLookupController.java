package com.thortful.cocktaillookup;

import com.thortful.cocktaillookup.services.CocktailLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CocktailLookupController {

    @Autowired
    CocktailLookupService cocktailLookupService;

    final String SOMETHING_WENT_WRONG = "Something went wrong while attempting to connect to thecocktaildb.com";
    final String VALUE_MISSING = "Please provide a value";

    @RequestMapping(value = "/getCocktails", method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCocktailsFromName(
            @RequestParam(value = "name", defaultValue = "margarita") String cocktailSearchQuery){
        try {
            if(cocktailSearchQuery.length() > 1) {
                return new ResponseEntity<>(cocktailLookupService.getCocktails(cocktailSearchQuery), HttpStatus.OK);
            }else if (cocktailSearchQuery.length() == 1){
                return new ResponseEntity<>(cocktailLookupService.getCocktailsFromLetter(cocktailSearchQuery), HttpStatus.OK);
            }else{
                // would not reach this because of the default value
                return new ResponseEntity<>(VALUE_MISSING, HttpStatus.BAD_REQUEST);
            }
        }catch (IOException e){
            return new ResponseEntity<>(SOMETHING_WENT_WRONG, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @RequestMapping(value = "/getCocktailInstructions", method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCocktailInstructions(
            @RequestParam(value = "name", defaultValue = "margarita") String cocktailSearchQuery){
        try {
            Map<String, String> instructions = new HashMap<>();
            if(cocktailSearchQuery.length() > 1) {
                cocktailLookupService.getCocktails(cocktailSearchQuery).getDrinks().forEach(drink ->
                    instructions.put(drink.getStrDrink(), drink.getStrInstructions()));
            }else if (cocktailSearchQuery.length() == 1){
                cocktailLookupService.getCocktailsFromLetter(cocktailSearchQuery).getDrinks().forEach(drink ->
                    instructions.put(drink.getStrDrink(), drink.getStrInstructions()));
            }else{
                // would not reach this because of the default value
                return new ResponseEntity<>(VALUE_MISSING, HttpStatus.OK);
            }
            return new ResponseEntity<>(instructions, HttpStatus.OK);
        }catch (IOException e){
            return new ResponseEntity<>(SOMETHING_WENT_WRONG, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }


}
