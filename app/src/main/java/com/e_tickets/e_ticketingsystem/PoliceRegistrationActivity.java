package com.e_tickets.e_ticketingsystem;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.concurrent.ExecutionException;

public class PoliceRegistrationActivity extends AppCompatActivity {
private String status = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_registration);
    }

    public void RegisterSubclicked(View view) {


        EditText badgenum = findViewById(R.id.badgeNum);

        EditText station = findViewById(R.id.stationCode);

        EditText Rank = findViewById(R.id.ranking);

        Offenderclass offenderclass = new Offenderclass();

        offenderclass.setPolice_pass(station.getText().toString());
        offenderclass.setBadgeNum(badgenum.getText().toString());
        offenderclass.setRank(Rank.getText().toString());

        NewPoliceDatabase newPoliceDatabase = new NewPoliceDatabase();
        newPoliceDatabase.execute(offenderclass);

        try {
            status = newPoliceDatabase.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (status.equalsIgnoreCase("Servers Updated succesfully")) {
            Snackbar.make(view, "Registration Complete", Snackbar.LENGTH_LONG)
                    .setAction("Registration", null).show();
            Intent RegisteredIntent = new Intent(PoliceRegistrationActivity.this, PoliceLogInActivity.class);
            startActivity(RegisteredIntent);
        }
    }

}
