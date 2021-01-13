package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

        ListView listView= (ListView) findViewById(R.id.TicketList);

        ArrayList<List> ticketList = new ArrayList();

        Statement statement =null;
        //This SQL Statement is not efficient. For large number of users we will change it to better efficient algorithm.
        try {
            statement = Login.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * From Game1 Where email="+"\'"+Login.userEmail.toString()+"\'"+";");
            Boolean userNotFound = true;
            while (resultSet.next()) {
                ArrayList numbers =new ArrayList();
                for(int i=2;i<=25;i++)
                {
                    numbers.add(resultSet.getString(i));
                }
                ticketList.add(numbers);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, ticketList.get(0));

            listView.setAdapter(adapter);
            Toast.makeText(this,ticketList.get(0).toString(),Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show();
        }
    }
}