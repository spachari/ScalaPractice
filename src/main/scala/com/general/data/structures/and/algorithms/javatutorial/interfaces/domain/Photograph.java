package com.general.data.structures.and.algorithms.javatutorial.interfaces.domain;

import com.general.data.structures.and.algorithms.javatutorial.interfaces.inter.Sellable;

public class Photograph implements Sellable {

    private String descript;
    private int price;
    private String colour;

    public Photograph(String description, int price, String color) {
        descript = description;
        this.price = price;
        this.colour = color;
    }

    @Override
    public String description() {
        return descript;
    }

    @Override
    public int listPrice() {
        return price;
    }

    @Override
    public int lowestPrice() {
        return price / 2;
    }

    public String getColour() {
        return colour;
    }
}
