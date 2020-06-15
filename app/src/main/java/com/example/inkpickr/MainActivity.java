package com.example.inkpickr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String a = "A"; String b = "B"; String c = "C"; String d = "D";
        final String[]tattoos = {a,b,c,d};

        Button randomButton = (Button) findViewById(R.id.randomButton);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView randomTattoo = (TextView) findViewById((R.id.randomTattoo));
                Random random = new Random();
                int randTat = random.nextInt(tattoos.length);
                randomTattoo.setText(tattoos[randTat]);
            }
        });
    }
}
