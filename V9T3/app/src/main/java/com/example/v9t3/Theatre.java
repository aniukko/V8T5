package com.example.v9t3;

public class Theatre {
    private String ID;
    private String name;

    public void theatreInfo(String i, String n) {
        ID = i;
        name = n;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}