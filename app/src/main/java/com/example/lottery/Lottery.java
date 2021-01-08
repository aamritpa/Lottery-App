package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

            GridLayout gridLayout= (GridLayout) findViewById(R.id.menuToolbar);
            if(gridLayout.getVisibility()==View.VISIBLE)
            {
                gridLayout.setVisibility(View.GONE);
            }
            else if(gridLayout.getVisibility()==View.GONE || gridLayout.getVisibility()==View.INVISIBLE)
            {
                gridLayout.setVisibility(View.VISIBLE);
            }
        }
        else if(view.getId()==R.id.lottoLayout)
        {
            GridLayout gridLayout= (GridLayout) findViewById(R.id.menuToolbar);
            gridLayout.setVisibility(View.GONE);
        }
    }
}