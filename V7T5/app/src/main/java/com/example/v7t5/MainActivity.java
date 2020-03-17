package com.example.v7t5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText fileName, writeText;
    Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        writeText = findViewById(R.id.writeText);
        fileName = findViewById(R.id.fileName);
        context = MainActivity.this;
    }

    public void save (View v) {
        try {
            String file = fileName.getText().toString();
            OutputStreamWriter osw = new OutputStreamWriter(context.openFileOutput(file, Context.MODE_PRIVATE));
            String w = writeText.getText().toString();
            writeText.setText(w);
            text.setText(w);
            osw.write(w);
            osw.close();

        } catch (IOException e) {
            Log.e("IOException", "Virhe syötteessä");
        } finally {
            System.out.println("Kirjoitettu");
        }
    }

    public void load (View v) {
        try {
            String file = fileName.getText().toString();
            InputStream ins = context.openFileInput(file);

            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String a = "";
            while ((a = br.readLine()) != null) {
                writeText.setText(a);
                text.setText(a);
            }
            ins.close();
        } catch (IOException e) {
            Log.e("IOException", "Error");
        } finally {
            System.out.println("Luettu");
        }
    }
}