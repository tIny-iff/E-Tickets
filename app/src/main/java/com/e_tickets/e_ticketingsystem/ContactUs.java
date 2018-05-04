package com.e_tickets.e_ticketingsystem;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

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
        EditText contact = findViewById(R.id.ContactUs);

        final SendEmail sendEmail =new SendEmail();
        sendEmail.setEmailData("trevidlas@gmail.com","Contact Us",contact.getText().toString());
        sendEmail.execute();
        try {
            String status=sendEmail.get();
            System.out.println("Email status:"+status);
            if(status.equalsIgnoreCase("Email was sent"))
            {
                //Toast.makeText(this,"Ticket was issued to commuter, logging out...",Toast.LENGTH_LONG).show();
                Intent logout = new Intent(ContactUs.this,MainActivity.class);
                startActivity(logout);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }






}


