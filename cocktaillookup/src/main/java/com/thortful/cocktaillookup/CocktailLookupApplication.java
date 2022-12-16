package com.thortful.cocktaillookup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;

@SpringBootApplication()
@Cacheable
public class CocktailLookupApplication {
	public static void main(String[] args) {
		SpringApplication.run(CocktailLookupApplication.class, args);
	}

}
