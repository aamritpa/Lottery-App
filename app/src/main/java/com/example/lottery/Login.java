package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends AppCompatActivity {

    private static String ip= "192.168.0.109";
    private static String port ="1433";
    private static String Classes= "net.sourceforge.jtds.jdbc.Driver";
    private static String database ="LoginCredentials";
    private static String username = "test";
    private static String password= "test";
    private static String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;
    static Connection connection =null;
    static String userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .detectAll().penaltyLog().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName(Classes);
            connection= DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException | SQLException e) {
            Toast.makeText(this,"Database Server Down",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
    public void toRegister(View view){
        Intent intent = new Intent(getApplicationContext(),Register.class);
        startActivity(intent);
    }
    public void toMainPage(View view){

        TextView email = (TextView) findViewById(R.id.loginEmail);
        userEmail= email.getText().toString();

        TextView password = (TextView) findViewById(R.id.loginPassword);
        String userPassword= password.getText().toString();

        if(connection!=null){
            Statement statement =null;
            //This SQL Statement is not efficient. For large number of users we will change it to better efficient algorithm.
            try{
                statement= connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select userEmail,userPassword From Registered;");
                Boolean userNotFound=true;
                while(resultSet.next())
                {
                    if (resultSet.getString(1).matches(userEmail))
                    {
                        Log.i("Email",resultSet.getString(1));
                        if(resultSet.getString(2).matches(userPassword))
                        {
                            userNotFound=false;
                            Intent intent= new Intent(getApplicationContext(),Lottery.class);
                            intent.putExtra("email",userEmail);  //Sending email to next activity
                            startActivity(intent);
                        }
                        else{
                            userNotFound=false;
                            Toast.makeText(this,"Password is Wrong!",Toast.LENGTH_LONG).show();
                        }
                    }
                }
                if(userNotFound==true)
                {
                    Toast.makeText(getApplicationContext(),"Email or Password is Wrong",Toast.LENGTH_LONG).show();
                }
                else {
                    //After login clear the email and password value
                    email.setText(null);
                    password.setText(null);
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            Toast.makeText(this,"Server Down Please Try Again Later",Toast.LENGTH_LONG).show();
        }



    }





}