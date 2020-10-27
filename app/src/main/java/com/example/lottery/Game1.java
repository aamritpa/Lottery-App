package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class Game1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
    }

    public void chooseNumber(View view){
        view.setBackgroundColor(Color.parseColor("#455C5A"));
    }
}