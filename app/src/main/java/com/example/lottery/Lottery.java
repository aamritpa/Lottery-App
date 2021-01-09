package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

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
        LinearLayout lottoLayout =(LinearLayout)findViewById(R.id.lottoLayout);
        if(view.getId()==R.id.game1)
        {
            Toast.makeText(this,"Game1",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(),Game1.class);
            intent.putExtra("email",userEmail);
            startActivity(intent);
        }
        else if(view.getId()==R.id.game2)
        {
            Toast.makeText(this,"Game2",Toast.LENGTH_LONG).show();

        }
        else if(view.getId()==R.id.menuButton)
        {



            if(menuLayout.getVisibility()==View.VISIBLE)
            {
                menuLayout.setVisibility(View.GONE);
                lottoLayout.setVisibility(View.VISIBLE);

            }
            else if(menuLayout.getVisibility()==View.GONE || menuLayout.getVisibility()==View.INVISIBLE)
            {
                menuLayout.setVisibility(View.VISIBLE);
                lottoLayout.setVisibility(View.GONE);
            }
        }
        else if(view.getId()==R.id.homeButton || view.getId()==R.id.homeIcon)
        {
            menuLayout.setVisibility(View.GONE);
            lottoLayout.setVisibility(View.VISIBLE);
        }
    }
}