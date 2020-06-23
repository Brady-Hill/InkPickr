package com.example.inkpickr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Drawable[] tattoos = new Drawable[5];
        Drawable a = getDrawable(R.drawable.tattoo1); tattoos[0] = a;
        Drawable b = getDrawable(R.drawable.tattoo2); tattoos[1] = b;
        Drawable c = getDrawable(R.drawable.tattoo3); tattoos[2] = c;
        Drawable d = getDrawable(R.drawable.tattoo4); tattoos[3] = d;
        Drawable e = getDrawable(R.drawable.tattoo5); tattoos[4] = e;

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
}
