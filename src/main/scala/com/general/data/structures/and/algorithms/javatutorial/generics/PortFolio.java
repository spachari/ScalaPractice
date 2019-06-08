package com.general.data.structures.and.algorithms.javatutorial.generics;

public class PortFolio<T> {

    Object[] data;

    public PortFolio(int capacity) {
        data =  new Object[capacity];
    }

    public T getData(int item) {
        return (T) data[item];
    }

    public void setData(int item, T value) {
        data[item] = value;
    }
}


class PortFolioTest {
    public static void main(String[] args) {

        PortFolio<String> p = new PortFolio<>(4);

        p.setData(0, "Facebook");
        p.setData(1, "Google");
        p.setData(2, "Amazon");
        p.setData(3, "Nike");

        System.out.println(p.getData(1));
        System.out.println(p.data.length);
        for (Object arr : p.data) {
            System.out.println("Share name is " + arr);
        }

    }
}