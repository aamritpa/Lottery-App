package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }
    @Override
    public void onBackPressed() { Help.this.finish();}
    public void goBack(View view) { Help.this.finish();}

}