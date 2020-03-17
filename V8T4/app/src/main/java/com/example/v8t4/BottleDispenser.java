package com.example.v8t4;

import android.widget.TextView;
import java.util.ArrayList;

public class BottleDispenser {

    private int bottles;
    private float money;

    private String print = "";

    private ArrayList<Bottle> bottle_list = new ArrayList<Bottle>();

    private static BottleDispenser dispenser = new BottleDispenser();

    private BottleDispenser() {
        money = 0;

        bottle_list.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 0.5, 1.8));
        bottle_list.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 1.5, 2.2));
        bottle_list.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 0.5, 2.0));
        bottle_list.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 1.5, 2.5));
        bottle_list.add(new Bottle("Fanta Zero", "Fanta", 0.3, 0.5, 1.95));

        bottles = bottle_list.size();
    }

    public static BottleDispenser getInstance() {
        return dispenser;
    }

    public void addMoney(TextView text, int progress) {
        money = progress/10;
        print = "Klink! Added more money!";
        text.setText(print);
    }

    public void buyBottle(TextView text, int nro) {
        if (money <= bottle_list.get(nro).getPrice()) {
            print = "Add money first";
            text.setText(print);
        }
        else if (bottles <= 0 ) {
            print = "No more bottles!";
            text.setText(print);
        }
        else {
            bottles -= 1;
            money -= bottle_list.get(nro).getPrice();
            print = "KACHUNK! " + bottle_list.get(nro).getName() + " came out of the dispenser!";
            text.setText(print);
            bottle_list.remove(nro);
        }
    }

    public void returnMoney(TextView text) {
        if (money <= 0) {
            print = "No more money!";
            text.setText(print);        }

        else {
            print = "Klink klink. Money came out! You got " + money + " back";
            text.setText(print);
            money = 0;
        }
    }

    public ArrayList<Bottle> getList () {
        return bottle_list;
    }
}