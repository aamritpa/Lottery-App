package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Register extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .detectAll().penaltyLog().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName(Classes);
            DriverManager.setLoginTimeout(10);
            connection= DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException | SQLException e) {
            TextView errorStatusRegister =(TextView)findViewById(R.id.errorStatusRegister);
            errorStatusRegister.setText("* Application is currently in maintenance, try again later.");
            Toast.makeText(this,"Database Server Down",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
    public void goToSignIn(View view){
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }
    public void onRegister(View view) throws SQLException {
        TextView firstName = (TextView) findViewById(R.id.userName);
        String userName= firstName.getText().toString();

        TextView lastName = (TextView) findViewById(R.id.lastNameProfile);
        String userLastName= lastName.getText().toString();

        TextView email = (TextView) findViewById(R.id.userEmail);
        Log.i("Email",email.getText().toString());
        String userEmail= email.getText().toString();

        EditText password = (EditText) findViewById(R.id.userPassword);
        String userPassword=  password.getText().toString();
        Log.i("Password",userPassword);

        EditText confirmPassword = (EditText) findViewById(R.id.userConfirmPassword);
        String userConfirmPassword=  confirmPassword.getText().toString();
        Log.i("Confirm Password",userConfirmPassword);

        TextView phoneNumber = (TextView) findViewById(R.id.userPhoneNumber);
        String userPhoneNumber= phoneNumber.getText().toString();

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
        TextView errorStatusRegister =(TextView)findViewById(R.id.errorStatusRegister);
        if(userName.isEmpty() || userEmail.isEmpty() ||userPassword.isEmpty() ||userConfirmPassword.isEmpty()
        || userAddress.isEmpty() || userCity.isEmpty() || userCountry.isEmpty() || userAge.isEmpty() || userLastName.isEmpty() || userPhoneNumber.isEmpty())
        {
            errorStatusRegister.setText("* Please enter all the fields given below.");
        }
        else if(!userConfirmPassword.matches(userPassword) )
        {
            errorStatusRegister.setText("* Confirm Password does not match with entered password.");
        }
        else if(connection!=null)
        {
            Statement statement=null;

            String queryStatement = "Insert into Registered " +
                    " (userName,userEmail,userPassword,userAddress,userCity,userCountry,userAge,userLastName,userPhoneNumber) values "
                    + "('" + userName + "','" + userEmail + "','" + userPassword + "','" + userAddress+
                    "','"+userCity+ "','"+userCountry+"','"+userAge+ "','"+userLastName+ "','"+userPhoneNumber+  "')";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
                preparedStatement.executeUpdate();
                //Log.i("Statement",String.valueOf(preparedStatement.executeUpdate()));
                preparedStatement.close();
                errorStatusRegister.setText("* User registered successfully.");
                firstName.setText(null);
                lastName.setText(null);
                email.setText(null);
                password.setText(null);
                phoneNumber.setText(null);
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
                errorStatusRegister.setText("* The email already exists within the system, try Sign In?");
            }
        }
        else
        {
            errorStatusRegister.setText("* Internet Connection Error, try restarting the application\"");
        }

    }
    @Override
    public void onBackPressed() { Register.this.finish();}

    public void goToNext(View view)
    {
        TextView firstName = (TextView) findViewById(R.id.userName);
        TextView lastName = (TextView) findViewById(R.id.lastNameProfile);
        TextView email = (TextView) findViewById(R.id.userEmail);
        TextView password = (TextView) findViewById(R.id.userPassword);
        TextView confirmPassword = (TextView) findViewById(R.id.userConfirmPassword);

        TextView firstNameText = (TextView) findViewById(R.id.nameText);
        TextView lastNameText = (TextView) findViewById(R.id.lastnameText);
        TextView emailText = (TextView) findViewById(R.id.emailText);
        TextView passwordText = (TextView) findViewById(R.id.passwordText);
        TextView confirmPasswordText = (TextView) findViewById(R.id.confirmPasswordText);

        ImageView nextImage = (ImageView) findViewById(R.id.next);
        TextView errorStatusRegister =(TextView)findViewById(R.id.errorStatusRegister);


        if(firstName.getText().toString().equals("") || lastName.getText().toString().equals("")
                || email.getText().toString().equals("") || password.getText().toString().equals("") || confirmPassword.getText().toString().equals(""))
        {
            errorStatusRegister.setText("* Please enter all the fields given below.");
        }
        else if(!confirmPassword.getText().toString().equals(password.getText().toString()))
        {
            errorStatusRegister.setText("* Confirm Password does not match with entered password.");
        }
        else
        {
            //Views that need to be invisible
            firstName.setVisibility(View.GONE);
            lastName.setVisibility(View.GONE);
            email.setVisibility(View.GONE);
            password.setVisibility(View.GONE);
            confirmPassword.setVisibility(View.GONE);
            firstNameText.setVisibility(View.GONE);
            lastNameText.setVisibility(View.GONE);
            emailText.setVisibility(View.GONE);
            passwordText.setVisibility(View.GONE);
            confirmPasswordText.setVisibility(View.GONE);
            nextImage.setVisibility(View.GONE);

            //Views that need to be Visible
            Button buttonRegister = (Button)findViewById(R.id.buttonRegister);
            TextView phoneNumberText = (TextView) findViewById(R.id.phoneNumberText);
            TextView addressText = (TextView) findViewById(R.id.addressText);
            TextView cityText = (TextView) findViewById(R.id.cityText);
            TextView countryText = (TextView) findViewById(R.id.countryText);
            TextView ageText = (TextView) findViewById(R.id.ageText);
            buttonRegister.setVisibility(View.VISIBLE);
            phoneNumberText.setVisibility(View.VISIBLE);
            addressText.setVisibility(View.VISIBLE);
            cityText.setVisibility(View.VISIBLE);
            countryText.setVisibility(View.VISIBLE);
            ageText.setVisibility(View.VISIBLE);

            TextView userPhoneNumber = (TextView) findViewById(R.id.userPhoneNumber);
            TextView userAddress = (TextView) findViewById(R.id.userAddress);
            TextView userCity = (TextView) findViewById(R.id.userCity);
            TextView userCountry = (TextView) findViewById(R.id.userCountry);
            TextView userAge = (TextView) findViewById(R.id.userAge);
            userPhoneNumber.setVisibility(View.VISIBLE);
            userAddress.setVisibility(View.VISIBLE);
            userCity.setVisibility(View.VISIBLE);
            userCountry.setVisibility(View.VISIBLE);
            userAge.setVisibility(View.VISIBLE);
        }
    }
    public void goBack(View view)
    {
        Register.this.finish();
    }
}