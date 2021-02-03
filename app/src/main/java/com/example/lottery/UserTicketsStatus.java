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

        TextView gameTypeView = (TextView)findViewById(R.id.gameType);
        gameTypeView.setText(gameType);

        TextView numbers_view = (TextView)findViewById(R.id.numbers);
        numbers_view.setText(numbers);
    }
    @Override
    public void onBackPressed() {
        UserTicketsStatus.this.finish();
    }
}