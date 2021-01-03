package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game1 extends AppCompatActivity {

    /* For General Numbers */
    int countSelected=0;
    TextView number1;
    TextView number2;
    TextView number3;
    TextView number4;
    TextView number5;
    TextView number6;
    TextView number7;
    Boolean alreadyExists;


    /* For Extra Numbers */

    int extraCount=0;
    TextView extra1;
    TextView extra2;
    TextView extra3;
    Boolean extraExists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
    }

    public void chooseNumber(View view){
        TextView selectedText =(TextView) findViewById(view.getId());
        alreadyExists=false;
        number1=(TextView) findViewById(R.id.selectedNumber1);
        number2=(TextView) findViewById(R.id.selectedNumber2);
        number3 =(TextView) findViewById(R.id.selectedNumber3);
        number4=(TextView) findViewById(R.id.selectedNumber4);;
        number5=(TextView) findViewById(R.id.selectedNumber5);;
        number6=(TextView) findViewById(R.id.selectedNumber6);;
        number7=(TextView) findViewById(R.id.selectedNumber7);;

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
            Toast.makeText(getApplicationContext(),"Maximum Numbers Selected",Toast.LENGTH_LONG).show();

        }
    }


    public void addExtra(View view)
    {
        TextView selectedText =(TextView) findViewById(view.getId());
        extraExists=false;
        number1=(TextView) findViewById(R.id.selectedNumber1);
        number2=(TextView) findViewById(R.id.selectedNumber2);
        number3 =(TextView) findViewById(R.id.selectedNumber3);
        number4=(TextView) findViewById(R.id.selectedNumber4);;
        number5=(TextView) findViewById(R.id.selectedNumber5);;
        number6=(TextView) findViewById(R.id.selectedNumber6);;
        number7=(TextView) findViewById(R.id.selectedNumber7);;
        extra1 =(TextView) findViewById(R.id.Extra1);
        extra2 =(TextView) findViewById(R.id.Extra2);
        extra3 =(TextView) findViewById(R.id.Extra3);


        if(!extra1.getText().toString().equals("") && !extraExists) {
            if (extra1.getText().toString().equals(selectedText.getText().toString())) {
                extra1.setText("");
                selectedText.setBackgroundColor(Color.parseColor("#C0C0C0"));
                extraExists = true;
                extraCount=extraCount-1;
                return;
            }
            else
            {
                extraExists=false;
            }
        }
        if(!extra2.getText().toString().equals("") && !extraExists) {
            if (extra2.getText().toString().equals( selectedText.getText().toString())) {
                extra2.setText("");
                selectedText.setBackgroundColor(Color.parseColor("#C0C0C0"));
                extraExists = true;
                extraCount=extraCount-1;
                return;
            }
            else
            {
                extraExists=false;
            }
        }
        if(!extra3.getText().toString().equals("") && !extraExists) {
            if (extra3.getText().toString().equals(selectedText.getText().toString())) {
                extra3.setText("");
                selectedText.setBackgroundColor(Color.parseColor("#C0C0C0"));
                extraExists = true;
                extraCount=extraCount-1;
                return;
            }
            else
            {
                extraExists=false;
            }
        }

        if(extraCount<3 && (!extraExists))
        {
            if(extra1.getText().toString().equals(""))
            {
                extra1.setText(selectedText.getText());
            }
            else if(extra2.getText().toString().equals(""))
            {
                extra2.setText(selectedText.getText());
            }
            else if(extra3.getText().toString().equals(""))
            {
                extra3.setText(selectedText.getText());
            }

            view.setBackgroundColor(Color.parseColor("#256B85"));
            extraCount=extraCount+1;
        }
        else if(extraCount>=3)
        {
            Toast.makeText(getApplicationContext(),"Maximum Numbers Selected",Toast.LENGTH_LONG).show();
        }
    }
    public void plusMinusDraw(View view)
    {
        TextView textView= (TextView) findViewById(R.id.totalDraws);
        if (getResources().getResourceEntryName(view.getId()).equals("minus"))
        {
            if(Integer.parseInt(textView.getText().toString())>=2)
            {
                textView.setText(String.valueOf(Integer.parseInt(textView.getText().toString())-1));
            }
            Toast.makeText(this, (getResources().getResourceEntryName(view.getId())).toString(), Toast.LENGTH_SHORT).show();

        }
        else if(getResources().getResourceEntryName(view.getId()).equals("plus")){
            if(Integer.parseInt(textView.getText().toString())<5)
            {
                textView.setText(String.valueOf(Integer.parseInt(textView.getText().toString())+1));
            }

        }
        TextView amount= (TextView) findViewById(R.id.amount);
        if(Integer.parseInt(textView.getText().toString())==1)
        {
            amount.setText(String.valueOf("100 ₹"));
        }
        else if(Integer.parseInt(textView.getText().toString())==2)
        {
            amount.setText(String.valueOf("200 ₹"));
        }
        else if(Integer.parseInt(textView.getText().toString())==3)
        {
            amount.setText(String.valueOf("300 ₹"));
        }
        else if(Integer.parseInt(textView.getText().toString())==4)
        {
            amount.setText(String.valueOf("400 ₹"));
        }
        else if(Integer.parseInt(textView.getText().toString())==5)
        {
            amount.setText(String.valueOf("500 ₹"));
        }
    }


    public void setRandomNumber(View view)
    {
        countSelected=7;
        extraCount=3;
        number1=(TextView) findViewById(R.id.selectedNumber1);
        number2=(TextView) findViewById(R.id.selectedNumber2);
        number3 =(TextView) findViewById(R.id.selectedNumber3);
        number4=(TextView) findViewById(R.id.selectedNumber4);;
        number5=(TextView) findViewById(R.id.selectedNumber5);;
        number6=(TextView) findViewById(R.id.selectedNumber6);;
        number7=(TextView) findViewById(R.id.selectedNumber7);;
        extra1 =(TextView) findViewById(R.id.Extra1);
        extra2 =(TextView) findViewById(R.id.Extra2);
        extra3 =(TextView) findViewById(R.id.Extra3);

        //Setting all numbers to empty string
        number1.setText("");number2.setText("");number3.setText("");number4.setText("");number5.setText("");number6.setText("");number7.setText("");
        extra1.setText("");extra2.setText("");extra3.setText("");


        for (int i = 1; i <= 50; i++) {
            TextView numbers = (TextView) findViewById(getResources().getIdentifier("number" + i, "id",
                    this.getPackageName()));
            numbers.setBackgroundColor(Color.parseColor("#C0C0C0"));
        }

        //Generating 7 numbers and storing in ArrayList
        ArrayList arrayListNumbers= new ArrayList(7);
        Random random= new Random();
        int countRandomNumber=1;
        while(countRandomNumber<=7) {
            int num = random.nextInt(50) + 1;
            if (!arrayListNumbers.contains(num)) {
                arrayListNumbers.add(num);
                countRandomNumber = countRandomNumber + 1;

            }
        }
        number1.setText(arrayListNumbers.get(0).toString());
        number2.setText(arrayListNumbers.get(1).toString());
        number3.setText(arrayListNumbers.get(2).toString());
        number4.setText(arrayListNumbers.get(3).toString());
        number5.setText(arrayListNumbers.get(4).toString());
        number6.setText(arrayListNumbers.get(5).toString());
        number7.setText(arrayListNumbers.get(6).toString());
        for (int i = 0; i <= 6; i++) {
            TextView numbers = (TextView) findViewById(getResources().getIdentifier("number" + arrayListNumbers.get(i), "id",
                    this.getPackageName()));
            numbers.setBackgroundColor(Color.parseColor("#256B85"));
        }

        //Random number generator for Extras


        for (int i = 65; i <= 90; i++) {
            TextView numbers = (TextView) findViewById(getResources().getIdentifier("number" + Character.toString((char)i), "id",
                    this.getPackageName()));
            numbers.setBackgroundColor(Color.parseColor("#C0C0C0"));
        }


        ArrayList listExtras= new ArrayList(3);
        int countRandomNumberExtra=1;
        while(countRandomNumberExtra<=3) {
            int num = random.nextInt(26) + 65;

             //converting integer to char (ASCII)
            String charValue = Character.toString((char)num);
            if (!listExtras.contains(charValue)) {
                listExtras.add(charValue);
                countRandomNumberExtra = countRandomNumberExtra + 1;
            }

        }
        extra1.setText(listExtras.get(0).toString());
        extra2.setText(listExtras.get(1).toString());
        extra3.setText(listExtras.get(2).toString());

        for (int i = 0; i <= 2; i++) {
            TextView numbers = (TextView) findViewById(getResources().getIdentifier("number" + listExtras.get(i), "id",
                    this.getPackageName()));
            numbers.setBackgroundColor(Color.parseColor("#256B85"));
        }
    }
    public void onConfirm(View view){
        if((countSelected==7 && extraCount==0) || (countSelected==7 && extraCount==3) )
        {
            TextView amount= (TextView) findViewById(R.id.amount);
            TextView totalDraws= (TextView) findViewById(R.id.totalDraws);
            Intent intent= new Intent(getApplicationContext(),Payment.class);
            intent.putExtra("number1",number1.getText());
            intent.putExtra("number2",number2.getText());
            intent.putExtra("number3",number3.getText());
            intent.putExtra("number4",number4.getText());
            intent.putExtra("number5",number5.getText());
            intent.putExtra("number6",number6.getText());
            intent.putExtra("number7",number7.getText());
            intent.putExtra("extra1",extra1.getText());
            intent.putExtra("extra2",extra2.getText());
            intent.putExtra("extra3",extra3.getText());
            intent.putExtra("amount",amount.getText().toString());
            intent.putExtra("totalDraws",Integer.valueOf(totalDraws.getText().toString()));
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Select Minimum Numbers!", Toast.LENGTH_SHORT).show();
        }
    }
}