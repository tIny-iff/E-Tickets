package com.e_tickets.e_ticketingsystem;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    }


        public void CancelClicked(View view)
        {
            Button cancel = (Button)findViewById(R.id.Cancel);

                    Intent cancelIntent = new Intent(ContactUs.this,MainActivity.class);
                    startActivity(cancelIntent);
                }




    public void SendClicked(View view)
    {
        ImageButton send = (ImageButton)findViewById(R.id.Send);

                Snackbar.make(view, "Email Sent", Snackbar.LENGTH_LONG)
                        .setAction("Contact Us",null).show();
//                Intent cancelIntent = new Intent(ContactUs.this, MainActivity.class);
//                startActivity(cancelIntent);
            }




    }


