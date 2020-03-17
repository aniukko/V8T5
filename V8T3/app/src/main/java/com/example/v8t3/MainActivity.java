package com.example.v8t3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text;
    BottleDispenser dispenser = BottleDispenser.getInstance();
    private SeekBar seekBar;
    private TextView textSeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        seekBar = findViewById(R.id.seekBar);
        textSeek = findViewById(R.id.textSeek);

        textSeek.setText(seekBar.getProgress()/10 + " / " + seekBar.getMax()/10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressValue;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue = progress;
                textSeek.setText(progress/10 + " / " + seekBar.getMax()/10);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textSeek.setText(progressValue/10 + " / " + seekBar.getMax()/10);
            }
        });
    }

    public void addMoney (View v) {
        dispenser.addMoney(text, seekBar.getProgress());
        seekBar.setProgress(0);
    }

    public void buyBottle (View v) {
        dispenser.buyBottle(text);
    }

    public void returnMoney (View v) {
        dispenser.returnMoney(text);
    }
}
