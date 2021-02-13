package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lottery extends AppCompatActivity {

    String userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottery);

        Intent intent = getIntent();
        userEmail= intent.getStringExtra("email");
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
    }
    @Override
    public void onBackPressed() {}
}