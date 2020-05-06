package com.example.v9t4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    readXML read = readXML.getInstance();
    Spinner spinner;
    TextView date;
    Button button;
    ListView list;
    TextView startT;
    TextView endT;

    private String chosenTheatre;
    private String chosenDate;
    private String chosenStart;
    private String chosenEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        date = findViewById(R.id.textDate);
        button = findViewById(R.id.button);
        list = findViewById(R.id.list);
        startT = findViewById(R.id.textTimeStart);
        endT = findViewById(R.id.textTimeEnd);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ArrayAdapter<Theatre> adapter = new ArrayAdapter<Theatre>(this, android.R.layout.simple_spinner_dropdown_item, read.theatreXML());
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chosenTheatre = parent.getItemAtPosition(position).toString();
                System.out.println(chosenTheatre);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosenDate = date.getText().toString();
                chosenStart = startT.getText().toString();
                chosenEnd = endT.getText().toString();

                ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, read.find(chosenTheatre, chosenDate, chosenStart, chosenEnd));
                list.setAdapter(listAdapter);
            }
        });
    }
}