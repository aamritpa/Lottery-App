package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserTickets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_tickets);

    }
    public void draw4UTickets(View view)
    {
        ListView listView= (ListView) findViewById(R.id.TicketList);

        ArrayList<String> ticketList = new ArrayList();

        Statement statement =null;
        //This SQL Statement is not efficient. For large number of users we will change it to better efficient algorithm.
        try {
            statement = Login.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * From Game1 Where email="+"\'"+Login.userEmail.toString()+"\'"+";");
            if(resultSet.next()==true)
            {

                while (resultSet.next()) {
                    String numberInString ="Numbers"+"\n\n";
                    for(int i=2;i<=25;i++)
                    {
                        numberInString=numberInString+"   "+resultSet.getString(i);
                        if(i==8 || i==15)
                        {
                            numberInString=numberInString+"\n";
                        }
                        if(i==22)
                        {
                            numberInString=numberInString+"\n\n";
                            numberInString=numberInString+"Extras"+"\n";
                        }

                    }
                    numberInString=numberInString+"\n\n";
                    ticketList.add(numberInString);
                }

            }
            else
            {
                ticketList.add("No Tickets Found!");
                Toast.makeText(this,"You have not bought any tickets yet",Toast.LENGTH_LONG).show();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, ticketList);

            listView.setAdapter(adapter);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show();
        }
    }
}