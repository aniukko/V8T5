package com.example.v8t2;


public class Bottle {

    private String name;
    private String manufacturer;
    private double total_energy;
    private double size;
    private double price;

    public Bottle(String n, String manu, double totE, double s, double p) {
        name = n;
        manufacturer = manu;
        total_energy = totE;
        size = s;
        price = p;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getEnergy() {
        return total_energy;
    }

    public double getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}