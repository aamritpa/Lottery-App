package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import static com.example.lottery.Login.connection;

public class ResetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

    }
    public void goBack(View view)
    {
        ResetPassword.this.finish();
    }
    public void resetPassword(View view)
    {
        EditText enteredEmail= (EditText)findViewById(R.id.enteredEmail);
        final TextView resetStatusMessage =(TextView) findViewById(R.id.resetStatusMessage);
        final TextView timeLeft =(TextView)findViewById(R.id.ResetPasswordTimer);
        Connection connection= Login.connection;
        String userName="";
        if(connection!=null && !enteredEmail.getText().toString().equals("")) {
            Statement statement = null;
            //This SQL Statement is not efficient. For large number of users we will change it to better efficient algorithm.
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select userEmail,userName From Registered Where userEmail="+"\'"+ enteredEmail.getText().toString()+"\'"+";");
                Boolean userNotFound = true;
                while (resultSet.next()) {
                    if (resultSet.getString(1).matches(enteredEmail.getText().toString())) {
                        userNotFound=false;
                        userName= resultSet.getString(2);
                    }
                }
                if (userNotFound == true)
                {
                    //Email Not found
                    resetStatusMessage.setText("The email address does not found");
                    resetStatusMessage.setVisibility(View.VISIBLE);
                    timeLeft.setVisibility(View.GONE);
                    Toast.makeText(this,"Not Found",Toast.LENGTH_LONG).show();
                }
                else
                {
                    //Email is found and give the user a new random password.

                    Random random = new Random();

                    String randomPassword="";
                    for (int i=0;i<=7;i++)
                    {

                        if (i%2==0)
                        {
                            char value = (char) (random.nextInt(26)+64);
                            randomPassword=randomPassword+value;
                        }
                        else if(i%3==0)
                        {
                            char value = (char) (random.nextInt(4)+35);
                            randomPassword=randomPassword+value;
                        }
                        else
                        {
                            char value = (char) (random.nextInt(25)+97);
                            randomPassword=randomPassword+value;
                        }

                    }
                    String subject = "Password Reset Requested: BigDraw Lottery";
                    timeLeft.setVisibility(View.VISIBLE);
                    String message = "Hello "+userName+",\n\n"
                            +"The new password to your BigDraw account is "+ randomPassword +"\n\n " +
                            "Do not share any kind of account information with others.\n\n"
                            +"If you have not requested for password change then we suggest to secure your " +
                            "account or contact our team for more clarification.";

                    String email =enteredEmail.getText().toString();

                    JavaMailAPI javaMailAPI = new JavaMailAPI(this,email,subject,message);
                    javaMailAPI.execute();

                    resetStatusMessage.setText("A temporary password has been sent to your email");
                    resetStatusMessage.setVisibility(View.VISIBLE);
                    final Button resetButton = (Button)findViewById(R.id.resetPasswordConfirmationbutton);
                    resetButton.setClickable(false);

                    /* Updating the database with new password */
                    String queryStatement = "UPDATE Registered Set userPassword= "+
                            "\'"+randomPassword+"\'"+
                            " Where userEmail="+ "\'"+enteredEmail.getText().toString()+"\';";
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
                    }

                    /* Setting Up the timer for rest button */
                    new CountDownTimer(60000,1000)
                        {
                            int count=0;
                            @Override
                            public void onTick(long millisUntilFinished) {
                                count=count+1;
                                timeLeft.setText("Did not receive it? Resend in "+String.valueOf(millisUntilFinished/1000) +" sec.");
                            }

                            @Override
                            public void onFinish() {
                                resetButton.setClickable(true);
                                resetStatusMessage.setVisibility(View.GONE);
                                timeLeft.setVisibility(View.GONE);

                            }
                        }.start();


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            if(enteredEmail.getText().toString().equals(""))
            {
                Toast.makeText(this,"Email Cannot be empty",Toast.LENGTH_LONG).show();

            }
            else
            {
                Toast.makeText(this,"The application is currently down for maintenance. Please Come Back Later ",Toast.LENGTH_LONG).show();
            }
        }
    }
}