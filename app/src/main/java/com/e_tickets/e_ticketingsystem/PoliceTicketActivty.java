package com.e_tickets.e_ticketingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PoliceTicketActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_ticket_activty);
    }


    public void EnterClicked(View view)
    {
        Button enter = findViewById(R.id.Enter);
        TextView trn = findViewById(R.id.TRN);

        String Tax_num= trn.getText().toString();

        Offenderclass off1 = new Offenderclass("",Tax_num,0,"","","","");
    }

    public void LocationClicked(View view)
    {
        Intent LocationView = new Intent(PoliceTicketActivty.this,MapsActivity.class);
        startActivity(LocationView);
    }
}
