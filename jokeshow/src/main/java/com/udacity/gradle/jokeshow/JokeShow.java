package com.udacity.gradle.jokeshow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeShow extends AppCompatActivity {
TextView joke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_show);
       joke =  (TextView) findViewById(R.id.text_view_joke);

        String jokeString = getIntent().getStringExtra("joke");

        joke.setText(jokeString);


    }
}
