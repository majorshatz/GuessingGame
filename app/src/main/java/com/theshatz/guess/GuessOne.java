package com.theshatz.guess;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GuessOne extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    int rando;
    public void buttonGuess(View view){

        EditText guessEditText=(EditText)findViewById(R.id.gNumber);
        String guess=(guessEditText.getText().toString());
        int guessed=Integer.parseInt(guess);
        //shows what's in guess field
        if(guessed<rando){
            makeToast(("Higher"));
        }
        if (guessed>rando){
            makeToast("Lower");
        }
        if (guessed==rando){
            makeToast("Just right");
            Random rand= new Random();
            rando = rand.nextInt(20)+1;
        }



    }
    public void makeToast(String toast){
        Toast.makeText(GuessOne.this,toast, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_one);
        //on create so doesn't recreate each time button is pressed.
        Random rand= new Random();
        rando = rand.nextInt(20)+1;
    }
}
