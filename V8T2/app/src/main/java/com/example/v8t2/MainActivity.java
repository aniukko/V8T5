package com.example.v8t2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    BottleDispenser dispenser = BottleDispenser.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
    }

    public void addMoney (View v) {
        dispenser.addMoney(text);
    }

    public void buyBottle (View v) {
        dispenser.buyBottle(text);
    }

    public void returnMoney (View v) {
        dispenser.returnMoney(text);
    }
}
