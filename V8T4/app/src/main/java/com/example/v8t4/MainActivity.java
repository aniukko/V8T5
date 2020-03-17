package com.example.v8t4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView text;
    BottleDispenser dispenser = BottleDispenser.getInstance();
    private SeekBar seekBar;
    private TextView textSeek;
    Spinner spinner;

    String spinnerText;
    int nro = 0;

    private String print = "";

    ArrayList<Bottle> list = dispenser.getList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textSeek = (TextView) findViewById(R.id.textSeek);
        spinner = (Spinner) findViewById(R.id.spinner);

        print = seekBar.getProgress()/10 + " / " + seekBar.getMax()/10;
        textSeek.setText(print);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressValue;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue = progress;
                print = progress/10 + " / " + seekBar.getMax()/10;
                textSeek.setText(print);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                print = progressValue/10 + " / " + seekBar.getMax()/10;
                textSeek.setText(print);
            }
        });

        ArrayAdapter<Bottle> adapter = new ArrayAdapter<Bottle>(this, android.R.layout.simple_spinner_dropdown_item, list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //spinnerText = parent.getItemAtPosition(position).toString();
                nro = position;
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
    }

    public void addMoney (View v) {
        dispenser.addMoney(text, seekBar.getProgress());
        seekBar.setProgress(0);
    }

    public void buyBottle (View v) {
        dispenser.buyBottle(text, nro);
    }

    public void returnMoney (View v) {
        dispenser.returnMoney(text);
    }
}