package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Game1 extends AppCompatActivity {

    int countSelected=0;
    TextView number1;
    TextView number2;
    TextView number3;
    TextView number4;
    TextView number5;
    TextView number6;
    TextView number7;
    Boolean alreadyExists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

    }

    public void chooseNumber(View view){
        TextView selectedText =(TextView) findViewById(view.getId());
        alreadyExists=false;
        number1 =(TextView) findViewById(R.id.selectedNumber1);
        number2 =(TextView) findViewById(R.id.selectedNumber2);
        number3 =(TextView) findViewById(R.id.selectedNumber3);
        number4 =(TextView) findViewById(R.id.selectedNumber4);
        number5 =(TextView) findViewById(R.id.selectedNumber5);
        number6 =(TextView) findViewById(R.id.selectedNumber6);
        number7 =(TextView) findViewById(R.id.selectedNumber7);


        if(!number1.getText().toString().equals("") && !alreadyExists) {
            if (Integer.valueOf(number1.getText().toString()).equals( Integer.valueOf(selectedText.getText().toString()))) {
                number1.setText("");
                selectedText.setBackgroundColor(Color.parseColor("#C0C0C0"));
                alreadyExists = true;
                countSelected=countSelected-1;
                return;
            }
            else
            {
                alreadyExists=false;
            }
        }
        if(!number2.getText().toString().equals("") && !alreadyExists) {
            if (Integer.valueOf(number2.getText().toString()).equals( Integer.valueOf(selectedText.getText().toString()))) {
                number2.setText("");
                selectedText.setBackgroundColor(Color.parseColor("#C0C0C0"));
                alreadyExists = true;
                countSelected=countSelected-1;
                return;
            }
            else
            {
                alreadyExists=false;
            }
        }
        if(!number3.getText().toString().equals("") && !alreadyExists) {
            if (Integer.valueOf(number3.getText().toString()).equals(Integer.valueOf(selectedText.getText().toString()))) {
                number3.setText("");
                selectedText.setBackgroundColor(Color.parseColor("#C0C0C0"));
                alreadyExists = true;
                countSelected=countSelected-1;
                return;
            }
            else
            {
                alreadyExists=false;
            }
        }
        if(!number4.getText().toString().equals("") && !alreadyExists) {
            if (Integer.valueOf(number4.getText().toString()).equals( Integer.valueOf(selectedText.getText().toString()))) {
                number4.setText("");
                selectedText.setBackgroundColor(Color.parseColor("#C0C0C0"));
                alreadyExists = true;
                countSelected=countSelected-1;
                return;
            }
            else
            {
                alreadyExists=false;
            }
        }
        if(!number5.getText().toString().equals("") && !alreadyExists) {
            if (Integer.valueOf(number5.getText().toString()).equals( Integer.valueOf(selectedText.getText().toString()))) {
                number5.setText("");
                selectedText.setBackgroundColor(Color.parseColor("#C0C0C0"));
                alreadyExists = true;
                countSelected=countSelected-1;
                return;
            }
            else
            {
                alreadyExists=false;
            }
        }
        if(!number6.getText().toString().equals("") && !alreadyExists) {
            if (Integer.valueOf(number6.getText().toString()).equals(Integer.valueOf(selectedText.getText().toString()))) {
                number6.setText("");
                selectedText.setBackgroundColor(Color.parseColor("#C0C0C0"));
                alreadyExists = true;
                countSelected=countSelected-1;
                return;
            }
            else
            {
                alreadyExists=false;
            }
        }
        if(!number7.getText().toString().equals("") && !alreadyExists) {
            if (Integer.valueOf(number7.getText().toString()).equals(Integer.valueOf(selectedText.getText().toString()))) {
                number7.setText("");
                selectedText.setBackgroundColor(Color.parseColor("#C0C0C0"));
                alreadyExists = true;
                countSelected=countSelected-1;
                return;
            }
            else
            {
                alreadyExists=false;
            }
        }

        if(countSelected<7 && (!alreadyExists))
        {
            if(number1.getText().toString().equals(""))
            {
                number1.setText(selectedText.getText());
            }
            else if(number2.getText().toString().equals(""))
            {
                number2.setText(selectedText.getText());
            }
            else if(number3.getText().toString().equals(""))
            {
                number3.setText(selectedText.getText());
            }
            else if(number4.getText().toString().equals(""))
            {
                number4.setText(selectedText.getText());
            }
            else if(number5.getText().toString().equals(""))
            {
                number5.setText(selectedText.getText());
            }
            else if(number6.getText().toString().equals(""))
            {
                number6.setText(selectedText.getText());
            }
            else if(number7.getText().toString().equals(""))
            {
                number7.setText(selectedText.getText());
            }
            view.setBackgroundColor(Color.parseColor("#256B85"));
            countSelected=countSelected+1;
        }
        else if(countSelected>=7)
        {
            Toast.makeText(getApplicationContext(),"Maximum numbers has been selected",Toast.LENGTH_LONG).show();

        }
        Toast.makeText(getApplicationContext(),String.valueOf(countSelected),Toast.LENGTH_LONG).show();

    }
}