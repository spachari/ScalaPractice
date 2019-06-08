package com.general.data.structures.and.algorithms.javatutorial.interfaces.domain;

import com.general.data.structures.and.algorithms.javatutorial.interfaces.inter.Sellable;
import com.general.data.structures.and.algorithms.javatutorial.interfaces.inter.Transportable;

public class BoxedItem implements Sellable, Transportable {

    private String descript;
    private int price;
    private int weight;
    private boolean haz;

    private int height = 0;
    private int width = 0;
    private int depth = 0;

    BoxedItem(String desc, int price, int weight, boolean haz) {
        descript = desc;
        this.price = price;
        this.weight = weight;
        this.haz = haz;
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

    @Override
    public int weight() {
        return weight;
    }

    @Override
    public boolean isHazardous() {
        return haz;
    }

    public void setBox(int h, int w, int d) {
        height = h;
        width = w;
        depth = d;
    }
}
