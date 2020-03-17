package com.example.v8t2;

import android.widget.TextView;

import java.util.ArrayList;

public class BottleDispenser {

    private int bottles;
    private float money;

    ArrayList<Bottle> bottle_list = new ArrayList<Bottle>();

    private static BottleDispenser dispenser = new BottleDispenser();

    private BottleDispenser() {
        bottles = 5;
        money = 0;

        bottle_list.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 0.5, 1.8));
        bottle_list.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 0.5, 1.8));
        bottle_list.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 0.5, 1.8));
        bottle_list.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 0.5, 1.8));
        bottle_list.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 0.5, 1.8));
    }

    public static BottleDispenser getInstance() {
        return dispenser;
    }

    public void addMoney(TextView text) {
        money += 1;
        text.setText("Klink! Added more money!");
    }

    public void buyBottle(TextView text) {
        if (money <= 1.8) {
            text.setText("Add money first!");
        }
        else if (bottles <= 0 ) {
            text.setText("No more bottles!");
        }
        else {
            bottles -= 1;
            money -= 1.8;
            text.setText("KACHUNK! Pepsi Max came out of the dispenser!");
            bottle_list.remove(0);
        }
    }

    public void returnMoney(TextView text) {
        if (money <= 0) {
            text.setText("No more money!");
        }

        else {
            text.setText("Klink klink. Money came out! You got " + money + " back");
            money = 0;
        }
    }
}
