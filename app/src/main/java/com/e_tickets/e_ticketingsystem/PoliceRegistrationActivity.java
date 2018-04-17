package com.e_tickets.e_ticketingsystem;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PoliceRegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_registration);
    }

    public void RegisterSubclicked(View view)
    {
        Button submit = (Button)findViewById(R.id.submit);

        Snackbar.make(view, "Registration Complete", Snackbar.LENGTH_LONG)
                .setAction("Registration",null).show();
//                Intent cancelIntent = new Intent(ContactUs.this, MainActivity.class);
//                startActivity(cancelIntent);
    }
}
