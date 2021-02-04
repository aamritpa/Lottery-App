package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class UserTicketsStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_tickets_status);

        Intent intent = getIntent();
        String gameType= intent.getStringExtra("gameType");
        String numbers= intent.getStringExtra("numbers");
        String gameStatus= intent.getStringExtra("gameStatus");
        String winningAmount= intent.getStringExtra("winningAmount");
        String drawDate= intent.getStringExtra("drawDate");

        TextView gameTypeView = (TextView)findViewById(R.id.gameType);
        gameTypeView.setText(gameType);

        TextView numbers_view = (TextView)findViewById(R.id.numbers);
        numbers_view.setText(numbers);

        TextView amountWinnerStatus = (TextView)findViewById(R.id.amountWinnerStatus);

        if(gameStatus.equals("0"))
        {
            amountWinnerStatus.setText("Not Drawn Yet");
        }
        else if(gameStatus.equals("1"))
        {
            amountWinnerStatus.setText("Not a Winner");
        }
        else if(gameStatus.equals("2"))
        {
            amountWinnerStatus.setText("Winner");
        }

        TextView amountWin = (TextView)findViewById(R.id.amountWin);
        amountWin.setText(winningAmount);

    }
    @Override
    public void onBackPressed() {
        UserTicketsStatus.this.finish();
    }
}