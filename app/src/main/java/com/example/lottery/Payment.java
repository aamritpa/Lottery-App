package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import static com.example.lottery.Login.connection;


public class Payment extends AppCompatActivity implements PaymentResultListener {


    String TAG= "PAYMENT ERROR";
    Button payButton;
    String amount;
    int totalDraws;
    int gameStatus=0; //Which game it is?

    TextView number1,number2,number3,number4,number5,number6,
            number7,number8,number9,number10,number11,number12,number13,number14
            ,number15,number16,number17,number18,number19,number20,number21;
    TextView extra1,extra2,extra3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Checkout.preload(getApplicationContext());

        Intent intent = getIntent();
        amount= intent.getStringExtra("amount");
        totalDraws= intent.getIntExtra("totalDraws",1);

        //Assigning all the selected values in Payment Activity
        number1 = (TextView)findViewById(R.id.finalizedNumber1);
        number1.setText(intent.getStringExtra("number1"));

        number2 = (TextView)findViewById(R.id.finalizedNumber2);
        number2.setText(intent.getStringExtra("number2"));

        number3 = (TextView)findViewById(R.id.finalizedNumber3);
        number3.setText(intent.getStringExtra("number3"));

        number4 = (TextView)findViewById(R.id.finalizedNumber4);
        number4.setText(intent.getStringExtra("number4"));

        number5 = (TextView)findViewById(R.id.finalizedNumber5);
        number5.setText(intent.getStringExtra("number5"));

        number6 = (TextView)findViewById(R.id.finalizedNumber6);
        number6.setText(intent.getStringExtra("number6"));

        number7 = (TextView)findViewById(R.id.finalizedNumber7);
        number7.setText(intent.getStringExtra("number7"));

        gameStatus=Integer.valueOf(intent.getStringExtra("number7"));

        /* Filling the second row of numbers */
        ArrayList arrayListNumbers= new ArrayList(7);
        Random random= new Random();
        int countRandomNumber=1;
        while(countRandomNumber<=7) {
            int num = random.nextInt(50) + 1;
            if (!arrayListNumbers.contains(num)) {
                arrayListNumbers.add(num);
                countRandomNumber = countRandomNumber + 1;
            }
        }


        //Assigning all the selected values in Payment Activity
        number8 = (TextView)findViewById(R.id.finalizedNumber8);
        number8.setText(arrayListNumbers.get(0).toString());

        number9 = (TextView)findViewById(R.id.finalizedNumber9);
        number9.setText(arrayListNumbers.get(1).toString());

        number10 = (TextView)findViewById(R.id.finalizedNumber10);
        number10.setText(arrayListNumbers.get(2).toString());

        number11 = (TextView)findViewById(R.id.finalizedNumber11);
        number11.setText(arrayListNumbers.get(3).toString());

        number12 = (TextView)findViewById(R.id.finalizedNumber12);
        number12.setText(arrayListNumbers.get(4).toString());

        number13 = (TextView)findViewById(R.id.finalizedNumber13);
        number13.setText(arrayListNumbers.get(5).toString());

        number14 = (TextView)findViewById(R.id.finalizedNumber14);
        number14.setText(arrayListNumbers.get(6).toString());


        /* Filling the third row of numbers */
        ArrayList arrayListNumbersThirdRow= new ArrayList(7);

        int countRandomNumber2=1;
        while(countRandomNumber2<=7) {
            int num = random.nextInt(50) + 1;
            if (!arrayListNumbersThirdRow.contains(num)) {
                arrayListNumbersThirdRow.add(num);
                countRandomNumber2 = countRandomNumber2 + 1;
            }
        }


        //Assigning all the selected values in Payment Activity
        number15 = (TextView)findViewById(R.id.finalizedNumber15);
        number15.setText(arrayListNumbersThirdRow.get(0).toString());

        number16 = (TextView)findViewById(R.id.finalizedNumber16);
        number16.setText(arrayListNumbersThirdRow.get(1).toString());

        number17 = (TextView)findViewById(R.id.finalizedNumber17);
        number17.setText(arrayListNumbersThirdRow.get(2).toString());

        number18 = (TextView)findViewById(R.id.finalizedNumber18);
        number18.setText(arrayListNumbersThirdRow.get(3).toString());

        number19 = (TextView)findViewById(R.id.finalizedNumber19);
        number19.setText(arrayListNumbersThirdRow.get(4).toString());

        number20 = (TextView)findViewById(R.id.finalizedNumber20);
        number20.setText(arrayListNumbersThirdRow.get(5).toString());

        number21 = (TextView)findViewById(R.id.finalizedNumber21);
        number21.setText(arrayListNumbersThirdRow.get(6).toString());

        //Filling the extra's numbers for game 1

        //
        extra1 = (TextView)findViewById(R.id.finalizedExtra1);
        extra1.setText(intent.getStringExtra("extra1"));

        extra2 = (TextView)findViewById(R.id.finalizedExtra2);
        extra2.setText(intent.getStringExtra("extra2"));

        extra3 = (TextView)findViewById(R.id.finalizedExtra3);
        extra3.setText(intent.getStringExtra("extra3"));


        TextView finalizedAmount= (TextView)findViewById(R.id.finalizedAmount);
        finalizedAmount.setText(amount);
        payButton= findViewById(R.id.payButton);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPayment();
            }
        });
    }

    @Override
    public void onPaymentSuccess(String s) {
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        Toast.makeText(this,date,Toast.LENGTH_LONG).show(); //Storing the date when the ticket is bought
        try {
            String game;
            if(gameStatus==0)
            {
                game= " Game1 ";
            }
            else
            {
                game= " Game2 ";
            }
            String queryNumbersStatement = "Insert into "+ game.toString() +
                    " (email,number1,number2,number3,number4,number5,number6,number7,number8,number9,number10,number11,number12,number13,number14,number15,number16,number17,number18,number19,number20,number21,extra1,extra2,extra3,draws,purchasedDate) values "
                    + "('" + Login.userEmail.toString() + "','" + number1.getText().toString() + "','" + number2.getText().toString() +
                    "','" + number3.getText().toString() + "','" + number4.getText().toString() + "','" + number5.getText().toString()
                    + "','" + number6.getText().toString() + "','" + number7.getText().toString() + "','" + number8.getText().toString()
                    + "','" + number9.getText().toString() + "','" + number10.getText().toString()
                    + "','" + number11.getText().toString() + "','" + number12.getText().toString() + "','" + number13.getText().toString()
                    + "','" + number14.getText().toString() + "','" + number15.getText().toString() + "','" + number16.getText().toString()
                    + "','" + number17.getText().toString() + "','" + number18.getText().toString() + "','" + number19.getText().toString()
                    + "','" + number20.getText().toString() + "','" + number21.getText().toString()+
                    "','"+extra1.getText().toString() + "','"+extra2.getText().toString()+"','"+ extra3.getText().toString()
                    +"','"+ String.valueOf(totalDraws)
                    +"','"+ date
                    + "')";


            PreparedStatement preparedStatement = connection.prepareStatement(queryNumbersStatement);
            preparedStatement.executeUpdate();
            //Log.i("Statement",String.valueOf(preparedStatement.executeUpdate()));
            Toast.makeText(this,"Successful",Toast.LENGTH_LONG).show();
            preparedStatement.close();

            Intent intent= new Intent(getApplicationContext(),Lottery.class);
            startActivity(intent);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this,"Database Storage Failed",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment Failed", Toast.LENGTH_SHORT).show();
    }

    public void startPayment() {

        if(connection!=null)
        {

            /**
             * Instantiate Checkout
             */
            Checkout checkout = new Checkout();
            checkout.setKeyID("rzp_test_hP9QsKNv9EYFBY");
            /**
             * Set your logo here
             */
            //checkout.setImage(R.drawable.logo);

            /**
             * Reference to current activity
             */
            final Activity activity = this;

            /**
             * Pass your payment options to the Razorpay Checkout as a JSONObject
             */
            try {
                JSONObject options = new JSONObject();

                options.put("name", "BigDraw");
                options.put("description", "BigDraw Lottery Corporation");
                //options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
                //options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
                //options.put("theme.color", "#3399cc");
                options.put("currency", "INR");
                options.put("amount", totalDraws*10000);//pass amount in currency subunits
                //options.put("prefill.email", "gaurav.kumar@example.com");
                //options.put("prefill.contact","9988776655");
                checkout.open(activity, options);
            } catch(Exception e) {
                Log.e(TAG, "Error in starting Razorpay Checkout", e);
            }
        }
    }
}

