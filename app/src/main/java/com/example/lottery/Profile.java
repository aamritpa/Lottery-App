package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.example.lottery.Login.connection;

public class Profile extends AppCompatActivity {

    TextView name;
    TextView email;
    TextView address;
    TextView city;
    TextView country;
    TextView age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = (TextView)findViewById(R.id.nameProfile);
        email = (TextView)findViewById(R.id.emailProfile);
        address = (TextView)findViewById(R.id.addressProfile);
        city = (TextView)findViewById(R.id.cityProfile);
        country = (TextView)findViewById(R.id.countryProfile);
        age = (TextView)findViewById(R.id.ageProfile);

        Statement statement =null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("Select * From Registered Where userEmail="+"\'"+Login.userEmail.toString()+"\'"+";");

            while (resultSet.next()) {
                name.setText(resultSet.getString(1));
                email.setText(resultSet.getString(2));
                address.setText(resultSet.getString(4));
                city.setText(resultSet.getString(5));
                country.setText(resultSet.getString(6));
                age.setText(resultSet.getString(7));
            }
        } catch (Exception e) {
            e.fillInStackTrace();
            Toast.makeText(this,"Failed To Get Information! Please Try Again Later.", Toast.LENGTH_LONG).show();
        }
    }
    public void saveProfile(View view)
    {

        String queryStatement = "UPDATE Registered Set "+
                "userName="+"\'"+name.getText().toString()+"\'" +","
                +"userAddress="+"\'"+address.getText().toString()+"\'"+ ","
                +"userCity="+"\'"+city.getText().toString()+"\'"+ ","
                +"userCountry="+"\'"+country.getText().toString()+"\'"+ ","
                +"userAge="+age.getText().toString()
                +"Where userAge=18;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.executeUpdate();
            //Log.i("Statement",String.valueOf(preparedStatement.executeUpdate()));
            preparedStatement.close();
            Toast.makeText(this,"Updated Successfully!",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this,"Update Failed!",Toast.LENGTH_LONG).show();
        }
    }

}