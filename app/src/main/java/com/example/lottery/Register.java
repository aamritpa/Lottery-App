package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Register extends AppCompatActivity {

    private static String ip= "192.168.0.109";
    private static String port ="1433";
    private static String Classes= "net.sourceforge.jtds.jdbc.Driver";
    private static String database ="LoginCredentials";
    private static String username = "test";
    private static String password= "test";
    private static String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;

    static Connection connection =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    public void goToSignIn(View view){
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }
    public void onRegister(View view) throws SQLException {
        TextView name = (TextView) findViewById(R.id.userName);
        Log.i("Name",name.getText().toString());
        String userName= name.getText().toString();

        TextView email = (TextView) findViewById(R.id.userEmail);
        Log.i("Email",email.getText().toString());
        String userEmail= email.getText().toString();

        EditText password = (EditText) findViewById(R.id.userPassword);
        String userPassword=  password.getText().toString();
        Log.i("Password",userPassword);

        EditText confirmPassword = (EditText) findViewById(R.id.userConfirmPassword);
        String userConfirmPassword=  confirmPassword.getText().toString();
        Log.i("Confirm Password",userConfirmPassword);

        TextView address = (TextView) findViewById(R.id.userAddress);
        Log.i("Address",address.getText().toString());
        String userAddress= address.getText().toString();

        TextView city = (TextView) findViewById(R.id.userCity);
        Log.i("City",city.getText().toString());
        String userCity= city.getText().toString();

        TextView country = (TextView) findViewById(R.id.userCountry);
        Log.i("Country",country.getText().toString());
        String userCountry= country.getText().toString();

        TextView age = (TextView) findViewById(R.id.userAge);
        Log.i("Age",age.getText().toString());
        String userAge= age.getText().toString();


        /* Error Handling */
        if(userName.isEmpty() || userEmail.isEmpty() ||userPassword.isEmpty() ||userConfirmPassword.isEmpty()
        || userAddress.isEmpty() || userCity.isEmpty() || userCountry.isEmpty() || userAge.isEmpty())
        {
            Toast.makeText(this,"Details Cannot Be Empty!",Toast.LENGTH_LONG).show();
        }
        else if(!userConfirmPassword.matches(userPassword) )
        {
            Toast.makeText(this,"Password does not match!",Toast.LENGTH_LONG).show();
        }
        else if(Integer.parseInt(userAge)<18)
        {
            Toast.makeText(this,"Age Does Not Quality, 18+ Only! ",Toast.LENGTH_LONG).show();
        }
        else if(connection!=null)
        {
            Statement statement=null;

            String queryStatement = "Insert into Registered " +
                    " (userName,userEmail,userPassword,userAddress,userCity,userCountry,userAge) values "
                    + "('" + userName + "','" + userEmail + "','" + userPassword + "','" + userAddress+
                    "','"+userCity+ "','"+userCountry+"','"+userAge+ "')";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
                preparedStatement.executeUpdate();
                //Log.i("Statement",String.valueOf(preparedStatement.executeUpdate()));
                preparedStatement.close();
                Toast.makeText(this,"Registered Successfully!",Toast.LENGTH_LONG).show();
                name.setText(null);
                email.setText(null);
                password.setText(null);
                confirmPassword.setText(null);
                address.setText(null);
                city.setText(null);
                country.setText(null);
                age.setText(null);
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                Toast.makeText(this,"Email Already Exists",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this,"Internet Connection Failed!",Toast.LENGTH_LONG).show();
        }


    }
}