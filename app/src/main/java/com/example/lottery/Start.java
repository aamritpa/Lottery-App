package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Start extends AppCompatActivity{


    private static String ip= "192.168.1.77";
    private static String port ="1433";
    private static String Classes= "net.sourceforge.jtds.jdbc.Driver";
    private static String database ="LoginCredentials";
    private static String username = "test";
    private static String password= "khalsaraj";
    private static String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;
    static Connection connection =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        new CountDownTimer(5000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                try {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
                    StrictMode.setThreadPolicy(policy);
                    Class.forName(Classes);
                    DriverManager.setLoginTimeout(10);
                    connection= DriverManager.getConnection(url,username,password);
                    Intent newIntent =new Intent(getApplicationContext(),Login.class);
                    startActivity(newIntent);

                } catch (ClassNotFoundException | SQLException e) {
                    TextView maintenanceNotice= (TextView)findViewById(R.id.maintenanceNotice);
                    maintenanceNotice.setVisibility(View.VISIBLE);
                    e.printStackTrace();
                }
            }
        }.start();
    }

}