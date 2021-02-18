package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.ResultSet;
import java.sql.Statement;

import static com.example.lottery.Login.connection;

public class Winners extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winners);

        Statement statement =null;
        //This SQL Statement is not efficient. For large number of users we will change it to better efficient algorithm.
        try {
            String draw4U ="";
            statement = connection.createStatement();
            TextView BigDraw4UWinners =(TextView)findViewById(R.id.BigDraw4UWinners);
            ResultSet resultSet = statement.executeQuery("Select * From Draw4UwinningNumbers Order By winningDate DESC;");
            while (resultSet.next()) {
                draw4U = "Numbers"+"\n\n"+resultSet.getString(1)+"  "+resultSet.getString(2)+"  "+resultSet.getString(3)+"  "
                +resultSet.getString(4)+"  "+resultSet.getString(5)+"  "+resultSet.getString(6)+"  "+resultSet.getString(7)
                +"\n\n" +"Extra"+"\n"+resultSet.getString(8)+"\n\n" +"Draw Date:  "+ resultSet.getString(9);
                break;
            }
            BigDraw4UWinners.setText(draw4U);
        }
        catch (Exception e)
        {
              e.printStackTrace();
        }

        try {
            String draw4State ="";
            statement = connection.createStatement();
            TextView BigDraw4StateWinners =(TextView)findViewById(R.id.BigDraw4StateWinners);
            ResultSet resultSet = statement.executeQuery("Select * From Draw4StatewinningNumbers Order By winningDate DESC;");
            while (resultSet.next()) {
                draw4State = "Numbers"+"\n\n"+resultSet.getString(1)+"  "+resultSet.getString(2)+"  "+resultSet.getString(3)+"  "
                        +resultSet.getString(4)+"  "+resultSet.getString(5)+"  "+resultSet.getString(6)+"  "+resultSet.getString(7)
                        +"\n\n" +"Extra"+"\n"+resultSet.getString(8)+"\n\n" +"Draw Date:  "+ resultSet.getString(9);
                break;
            }
            BigDraw4StateWinners.setText(draw4State);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
    @Override
    public void onBackPressed() { Winners.this.finish();}
    public void goBack(View view) { Winners.this.finish();}
}