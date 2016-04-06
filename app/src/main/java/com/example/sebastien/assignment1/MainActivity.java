package com.example.sebastien.assignment1;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int compNumber;
    private EditText number;
    private ImageView image;
    private int numLives;
    private TextView lives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = (EditText) findViewById(R.id.number);
        Random randy = new Random();
        compNumber = randy.nextInt(1000);
        image = (ImageView) findViewById(R.id.imageCenter);
        numLives = 14;
        lives = (TextView) findViewById(R.id.lives);
        lives.setText("Lives: " + numLives);
    }

    public void guessNumber(View view) {
        String value = String.valueOf(number.getText());
        int guess = Integer.valueOf(value);
        if (numLives == 0) {
            Toast.makeText(this, "You Lose!!", Toast.LENGTH_LONG).show();
            image.setImageResource(R.drawable.loser);
            TextView youLose = (TextView) findViewById(R.id.loserText);
            youLose.setText("The number was: " + compNumber);
        }else if (guess < compNumber) {
            Toast.makeText(this, "Think Bigger!", Toast.LENGTH_SHORT).show();
            image.setImageResource(R.drawable.arrowup);
            numLives--;
            lives.setText("Lives: " + numLives);
        } else if (guess > compNumber) {
            Toast.makeText(this, "Think Smaller!", Toast.LENGTH_SHORT).show();
            image.setImageResource(R.drawable.arrowdown);
            numLives--;
            lives.setText("Lives: " + numLives);
        } else {
            Toast.makeText(this, "Nailed it!", Toast.LENGTH_SHORT).show();
            image.setImageResource(R.drawable.winner);
        }
    }
}
