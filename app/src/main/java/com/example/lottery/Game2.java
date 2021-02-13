package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Game2 extends AppCompatActivity {


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
    ArrayList listExtras= new ArrayList(3);;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
    }

    public void choosegame2Number(View view)
    {
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
    public void plusMinusDraw(View view)
    {
        TextView totalDraws= (TextView) findViewById(R.id.totalDraws);
        if (getResources().getResourceEntryName(view.getId()).equals("minus"))
        {
            if(Integer.parseInt(totalDraws.getText().toString())>=2)
            {
                totalDraws.setText(String.valueOf(Integer.parseInt(totalDraws.getText().toString())-1));
            }
            Toast.makeText(this, (getResources().getResourceEntryName(view.getId())).toString(), Toast.LENGTH_SHORT).show();

        }
        else if(getResources().getResourceEntryName(view.getId()).equals("plus")){
            if(Integer.parseInt(totalDraws.getText().toString())<5)
            {
                totalDraws.setText(String.valueOf(Integer.parseInt(totalDraws.getText().toString())+1));
            }

        }
        TextView amount= (TextView) findViewById(R.id.game2amount);
        if(Integer.parseInt(totalDraws.getText().toString())==1)
        {
            amount.setText(String.valueOf("100 ₹"));
        }
        else if(Integer.parseInt(totalDraws.getText().toString())==2)
        {
            amount.setText(String.valueOf("200 ₹"));
        }
        else if(Integer.parseInt(totalDraws.getText().toString())==3)
        {
            amount.setText(String.valueOf("300 ₹"));
        }
        else if(Integer.parseInt(totalDraws.getText().toString())==4)
        {
            amount.setText(String.valueOf("400 ₹"));
        }
        else if(Integer.parseInt(totalDraws.getText().toString())==5)
        {
            amount.setText(String.valueOf("500 ₹"));
        }
    }

    public void setRandomNumberGame2(View view)
    {
        countSelected=7;
        number1=(TextView) findViewById(R.id.selectedNumber1);
        number2=(TextView) findViewById(R.id.selectedNumber2);
        number3 =(TextView) findViewById(R.id.selectedNumber3);
        number4=(TextView) findViewById(R.id.selectedNumber4);;
        number5=(TextView) findViewById(R.id.selectedNumber5);;
        number6=(TextView) findViewById(R.id.selectedNumber6);;
        number7=(TextView) findViewById(R.id.selectedNumber7);;


        //Setting all numbers to empty string
        number1.setText("");number2.setText("");number3.setText("");number4.setText("");number5.setText("");number6.setText("");number7.setText("");

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

    }
    public void onConfirmGame2(View view){
        if(countSelected==7)
        {
            //Random number generator for Extras
            Random random= new Random();
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

            TextView amount= (TextView) findViewById(R.id.game2amount);
            TextView totalDraws= (TextView) findViewById(R.id.totalDraws);
            Intent intent= new Intent(getApplicationContext(),Payment.class);
            intent.putExtra("number1",number1.getText().toString());
            intent.putExtra("number2",number2.getText().toString());
            intent.putExtra("number3",number3.getText().toString());
            intent.putExtra("number4",number4.getText().toString());
            intent.putExtra("number5",number5.getText().toString());
            intent.putExtra("number6",number6.getText().toString());
            intent.putExtra("number7",number7.getText().toString());
            intent.putExtra("extra1",listExtras.get(0).toString());
            intent.putExtra("extra2",listExtras.get(1).toString());
            intent.putExtra("extra3",listExtras.get(2).toString());
            intent.putExtra("amount",amount.getText().toString());
            intent.putExtra("totalDraws",Integer.valueOf(totalDraws.getText().toString()));
            intent.putExtra("gameType","1"); //0 means game1, 1 means game2
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Select Minimum Numbers!", Toast.LENGTH_SHORT).show();
        }
    }

    public void goToMenu(View view)
    {
        GridLayout menuLayout= (GridLayout) findViewById(R.id.menuToolbarGame2);
        Button random= (Button) findViewById(R.id.game2random);
        if(view.getId()==R.id.menuButtonGame2)
        {
            if(menuLayout.getVisibility()==View.VISIBLE)
            {
                menuLayout.setVisibility(View.GONE);
                random.setVisibility(View.VISIBLE);
            }
            else if(menuLayout.getVisibility()==View.GONE || menuLayout.getVisibility()==View.INVISIBLE)
            {
                menuLayout.setVisibility(View.VISIBLE);
                random.setVisibility(View.INVISIBLE);
            }
        }
        else if(view.getId()==R.id.homeButton || view.getId()==R.id.homeIcon)
        {
            menuLayout.setVisibility(View.GONE);
            random.setVisibility(View.VISIBLE);
            Intent intent =new Intent(getApplicationContext(),Lottery.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.myProfileButton || view.getId()==R.id.myProfileIcon)
        {
            Intent intent = new Intent(getApplicationContext(),Profile.class);
            startActivity(intent);
            menuLayout.setVisibility(View.GONE);
        }
        else if(view.getId()==R.id.TicketsButton || view.getId()==R.id.TicketsIcon)
        {
            Intent intent = new Intent(getApplicationContext(),UserTickets.class);
            startActivity(intent);
            menuLayout.setVisibility(View.GONE);
        }
        else if(view.getId()==R.id.walletButton || view.getId()==R.id.walletIcon)
        {
            Intent intent = new Intent(getApplicationContext(),Wallet.class);
            startActivity(intent);
            menuLayout.setVisibility(View.GONE);
        }
        else if(view.getId()==R.id.helpButton || view.getId()==R.id.helpIcon)
        {
            Intent intent = new Intent(getApplicationContext(),Help.class);
            startActivity(intent);
            menuLayout.setVisibility(View.GONE);
        }
        else if(view.getId()==R.id.winnerButton || view.getId()==R.id.winnerIcon)
        {
            Intent intent = new Intent(getApplicationContext(),Winners.class);
            startActivity(intent);
            menuLayout.setVisibility(View.GONE);
        }
        else if(view.getId()==R.id.aboutButton || view.getId()==R.id.aboutIcon)
        {
            Intent intent = new Intent(getApplicationContext(),About.class);
            startActivity(intent);
            menuLayout.setVisibility(View.GONE);
        }
        else if(view.getId()==R.id.logoutIconDraw4State || view.getId()==R.id.logoutButtonDraw4State)
        {
            Intent intent = new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
            menuLayout.setVisibility(View.GONE);
        }
    }
    @Override
    public void onBackPressed() { Game2.this.finish();}
}