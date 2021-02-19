package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.lottery.Login.connection;

public class Lottery extends AppCompatActivity {

    String userEmail;
    TextView lotteryDate;
    TextView numberText1;
    TextView numberText2;
    TextView numberText3;
    TextView numberText4;
    TextView numberText5;
    TextView numberText6;
    TextView numberText7;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottery);

        Intent intent = getIntent();
        userEmail= intent.getStringExtra("email");
        lotteryDate= (TextView)findViewById(R.id.lotteryDate);
        numberText1= (TextView)findViewById(R.id.numbertext1);
        numberText2= (TextView)findViewById(R.id.numbertext2);
        numberText3= (TextView)findViewById(R.id.numbertext3);
        numberText4= (TextView)findViewById(R.id.numbertext4);
        numberText5= (TextView)findViewById(R.id.numbertext5);
        numberText6= (TextView)findViewById(R.id.numbertext6);
        numberText7= (TextView)findViewById(R.id.numbertext7);

        Statement statement=null;
        try {
            statement= connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * From Draw4UwinningNumbers Order By winningDate DESC;");
            while(resultSet.next())
            {
                numberText1.setText(resultSet.getString(1));
                numberText2.setText(resultSet.getString(2));
                numberText3.setText(resultSet.getString(3));
                numberText4.setText(resultSet.getString(4));
                numberText5.setText(resultSet.getString(5));
                numberText6.setText(resultSet.getString(6));
                numberText7.setText(resultSet.getString(7));
                lotteryDate.setText(resultSet.getString(9));
                break;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    public void goToGame(View view)
    {
        GridLayout menuLayout= (GridLayout) findViewById(R.id.menuToolbar);
        if(view.getId()==R.id.game1)
        {
            Intent intent = new Intent(getApplicationContext(),Game1.class);
            intent.putExtra("email",userEmail);
            startActivity(intent);
            menuLayout.setVisibility(View.GONE);
        }
        else if(view.getId()==R.id.game2)
        {
            Intent intent = new Intent(getApplicationContext(),Game2.class);
            intent.putExtra("email",userEmail);
            startActivity(intent);
            menuLayout.setVisibility(View.GONE);

        }
    }
    public void goToMenu(View view)
    {
        GridLayout menuLayout= (GridLayout) findViewById(R.id.menuToolbar);
        LinearLayout lottoLayout =(LinearLayout)findViewById(R.id.lottoLayout);
        if(view.getId()==R.id.menuButton)
        {
            if(menuLayout.getVisibility()==View.VISIBLE)
            {
                menuLayout.setVisibility(View.GONE);
                //lottoLayout.setVisibility(View.VISIBLE);
            }
            else if(menuLayout.getVisibility()==View.GONE || menuLayout.getVisibility()==View.INVISIBLE)
            {
                menuLayout.setVisibility(View.VISIBLE);
                //lottoLayout.setVisibility(View.GONE);
            }
        }
        else if(view.getId()==R.id.homeButton || view.getId()==R.id.homeIcon)
        {
            menuLayout.setVisibility(View.GONE);
            lottoLayout.setVisibility(View.VISIBLE);
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
        else if(view.getId()==R.id.logoutButton || view.getId()==R.id.logoutIcon)
        {

            Intent intent = new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
            menuLayout.setVisibility(View.GONE);
        }
        else if(view.getId()==R.id.scrollViewlotteryPage || view.getId()==R.id.lotteryTypeText || view.getId()==R.id.lotteryDate)
        {
            menuLayout.setVisibility(View.GONE);
        }
    }
    @Override
    public void onBackPressed() {}


    public void showDraw4U()
    {
    }

    public void showDraw4State()
    {

    }
}