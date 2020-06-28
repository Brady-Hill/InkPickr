package com.example.inkpickr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Drawable[] tattoos;

    final Drawable[] allTattoos = new Drawable[5];

    final Drawable[] tribal = new Drawable[2];

    final Drawable[] flash = new Drawable[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set Up Spinner
        Spinner spinner = findViewById(R.id.spinnerTattoo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.tattooSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //Populate Arrays
        Drawable a = getDrawable(R.drawable.tattoo1); allTattoos[0] = a;
        Drawable b = getDrawable(R.drawable.tattoo2); allTattoos[1] = b;
        Drawable c = getDrawable(R.drawable.tattoo3); allTattoos[2] = c;
        Drawable d = getDrawable(R.drawable.tattoo4); allTattoos[3] = d;
        Drawable e = getDrawable(R.drawable.tattoo5); allTattoos[4] = e;

        tribal[0] = d; tribal[1] = e;

        flash[0] = a; flash[1] = b; flash[2] = c;

        //Set up Button Click
        Button randomButton = (Button) findViewById(R.id.randomButton);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView randomTattoo = (ImageView) findViewById((R.id.randomTattoo));
                Random random = new Random();
                int randTat = random.nextInt(tattoos.length);
                randomTattoo.setImageDrawable(tattoos[randTat]);
            }
        });
    }
    //Set up Item Selection For Spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(position){
            case 0: tattoos = allTattoos;
            break;
            case 1: tattoos = tribal;
            break;
            case 2: tattoos = flash;
            break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        tattoos = allTattoos;
    }
}
