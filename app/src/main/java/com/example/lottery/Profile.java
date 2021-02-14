package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.example.lottery.Login.connection;

public class Profile extends AppCompatActivity {

    TextView firstName;
    TextView lastName;
    TextView email;
    TextView phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firstName = (TextView)findViewById(R.id.firstnameProfile);
        lastName=(TextView)findViewById(R.id.lastNameProfile);
        email = (TextView)findViewById(R.id.emailAddressProfile);
        phoneNumber = (TextView)findViewById(R.id.phoneNumberProfile);


        Statement statement =null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("Select * From Registered Where userEmail="+"\'"+Login.userEmail.toString()+"\'"+";");

            while (resultSet.next()) {
                firstName.setText(resultSet.getString(1));
                lastName.setText(resultSet.getString(8));
                email.setText(resultSet.getString(2));
                phoneNumber.setText(resultSet.getString(9));
            }
        } catch (Exception e) {
            e.fillInStackTrace();
            Toast.makeText(this,"Failed To Get Information! Please Try Again Later.", Toast.LENGTH_LONG).show();
        }
    }
    public void saveProfile(View view)
    {
    //Updating the user information
        String queryStatement = "UPDATE Registered Set userName= "+
                "\'"+firstName.getText().toString() +"\'"
                + " , " +
                "userLastName= "+
                "\'"+lastName.getText().toString() +"\'"
                + " , " +
                "userPhoneNumber= "+
                "\'"+phoneNumber.getText().toString() +"\'" +
                " Where userEmail="+ "\'"+email.getText().toString()+"\';";
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
    public void goBack(View view)
    {
        Profile.this.finish();
    }

    @Override
    public void onBackPressed() { Profile.this.finish();}


    public void passwordChange(View view)
    {
        androidx.gridlayout.widget.GridLayout gridLayout = (androidx.gridlayout.widget.GridLayout)findViewById(R.id.passwordLayout);
        gridLayout.setVisibility(View.VISIBLE);
        Button button =(Button)findViewById(R.id.confirmNewPasswordButton);
        button.setVisibility(View.VISIBLE);
    }
    public void confirmPasswordChange(View view)
    {
        EditText oldPassword =(EditText)findViewById(R.id.oldPassword);
        EditText newPassword =(EditText)findViewById(R.id.newPassword);
        EditText newConfirmPassword =(EditText)findViewById(R.id.confirmNewPassword);

        String realPassword = Login.userPassword;
        if(oldPassword.getText().toString().equals("") || newPassword.getText().toString().equals("") || newConfirmPassword.getText().toString().equals(""))
        {
            Toast.makeText(this,"Enter Complete Details",Toast.LENGTH_LONG).show();
        }
        else if(!oldPassword.getText().toString().equals(realPassword))
        {
            Toast.makeText(this,"Current Password Is Wrong",Toast.LENGTH_LONG).show();
        }
        else if(!newPassword.getText().toString().equals(newConfirmPassword.getText().toString()))
        {
            Toast.makeText(this,"Confirm Password Does Not Match",Toast.LENGTH_LONG).show();
        }
        else
        {
            //Updating the user information
            String queryStatement = "UPDATE Registered Set userPassword= "+
                    "\'"+newPassword.getText().toString() +"\'" +
                    " Where userEmail="+ "\'"+email.getText().toString()+"\';";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
                preparedStatement.executeUpdate();
                //Log.i("Statement",String.valueOf(preparedStatement.executeUpdate()));
                preparedStatement.close();
                Toast.makeText(this,"Password Updated Successfully!",Toast.LENGTH_LONG).show();

                oldPassword.setText("");
                newPassword.setText("");
                newConfirmPassword.setText("");
            }
            catch (Exception e)
            {
                e.printStackTrace();
                Toast.makeText(this,"Update Failed!",Toast.LENGTH_LONG).show();
            }
        }


    }
}