package com.thortful.cocktaillookup.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Drinks{
    @JsonProperty("drinks")
    public ArrayList<Drink> getDrinks() {
        return this.drinks; }
    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks; }
    ArrayList<Drink> drinks;
}
