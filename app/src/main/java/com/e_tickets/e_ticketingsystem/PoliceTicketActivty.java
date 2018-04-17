package com.e_tickets.e_ticketingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

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


        if(trn != null)
        {
            TextView fname = findViewById(R.id.fname);
            String f_name= fname.getText().toString();
            fname.setVisibility(View.VISIBLE);

            TextView lname = findViewById(R.id.lname);
            String l_name = lname.getText().toString();
            lname.setVisibility(View.VISIBLE);

            TextView email = findViewById(R.id.Email);
            email.setVisibility(View.VISIBLE);


            TextView gender = findViewById(R.id.gender);
            gender.setVisibility(View.VISIBLE);


            TextView LicensePlnum = findViewById(R.id.licensePlnum);
            LicensePlnum.setVisibility(View.VISIBLE);




            TextView locationview = findViewById(R.id.Location);
            String location= locationview.getText().toString();

            EditText feesview = findViewById(R.id.Fee);
            feesview.setVisibility(View.VISIBLE);




            String Tax_num= trn.getText().toString();




            Offenderclass off1 = new Offenderclass(f_name,l_name,"",Tax_num,0,"","","","",location);
        }


    }

    public void LocationClicked(View view)
    {
        Intent LocationView = new Intent(PoliceTicketActivty.this,MapsActivity.class);
        startActivity(LocationView);
    }

    public void TicketClicked(View view)
    {
        
    }
}
