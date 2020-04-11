package com.doiliomatsinhe.androidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView textJoke = findViewById(R.id.text_joke);

        // Gets the Joke as an Intent extra and displays it on the screen.

        Intent i = getIntent();
        if (i != null) {
            String myJoke = i.getStringExtra(JOKE);
            if (myJoke != null && !myJoke.isEmpty()) {
                textJoke.setText(myJoke);
            }

        }
    }
}
