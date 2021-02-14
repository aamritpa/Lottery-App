package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserTickets extends AppCompatActivity {

    private String gameStatus="";
    private String winningAmount="";
    private String drawDate="";
    private String gameType="";
    private String purchasedDate="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_tickets);

    }
    public void Tickets(View view)
    {
        ListView listView= (ListView) findViewById(R.id.TicketList);

        ArrayList<String> ticketList = new ArrayList();

        Statement statement =null;
        //This SQL Statement is not efficient. For large number of users we will change it to better efficient algorithm.
        try {
            statement = Login.connection.createStatement();
            String gameName="";

            if(view.getId()==R.id.Draw4UTickets)
            {
                gameName= " Game1 ";
                gameType= "Draw4U Lottery";
            }
            else if(view.getId()==R.id.Draw4StateTickets)
            {
                gameName= " Game2 ";
                gameType= "Draw4State Lottery";
            }

            ResultSet resultSet = statement.executeQuery("Select * From "+ gameName +"Where email="+"\'"+Login.userEmail.toString()+"\'"+";");
            if(resultSet!=null)
            {
                while (resultSet.next()) {
                    String numberInString ="\n"+" Numbers "+"\n\n";
                    for(int i=2;i<=30;i++)
                    {
                        if(i>=2 && i<=25)
                        {
                            numberInString=numberInString+"   "+resultSet.getString(i);
                        }
                        if(i==8 || i==15)
                        {
                            numberInString=numberInString+"\n";
                        }
                        else if(i==22)
                        {
                            numberInString=numberInString+"\n\n";
                            numberInString=numberInString+" Extras "+"\n\n";
                        }
                        else if(i==27)
                        {
                            purchasedDate=resultSet.getString(i);
                        }
                        else if(i==28){
                            gameStatus=resultSet.getString(i);
                        }
                        else if(i==29)
                        {
                            drawDate=resultSet.getString(i);
                        }
                        else if(i==30)
                        {
                            winningAmount=resultSet.getString(i);
                        }
                    }
                    numberInString=numberInString+"\n\n";
                    ticketList.add(numberInString);
                }

            }
            else
            {
                ticketList.add("No Tickets Found!");
                Toast.makeText(this,"No Tickets Found",Toast.LENGTH_LONG).show();
            }
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, ticketList);

            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String value=adapter.getItem(position);
                    Intent userTicketStatus = new Intent(getApplicationContext(),UserTicketsStatus.class);
                    userTicketStatus.putExtra("numbers",value.toString());  //Sending email to next activity
                    userTicketStatus.putExtra("gameType",gameType.toString());
                    userTicketStatus.putExtra("gameStatus",gameStatus.toString());
                    userTicketStatus.putExtra("winningAmount",winningAmount.toString());
                    userTicketStatus.putExtra("drawDate",drawDate.toString());
                    userTicketStatus.putExtra("purchasedDate",purchasedDate.toString());
                    startActivity(userTicketStatus);

                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show();
        }
    }
    public void goBack(View view){
        UserTickets.this.finish();
    }
}