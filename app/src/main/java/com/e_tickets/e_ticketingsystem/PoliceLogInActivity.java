package com.e_tickets.e_ticketingsystem;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class PoliceLogInActivity extends AppCompatActivity {

    private  EditText Memail;
    private  EditText Mpassword;

    ProgressBar prgPolice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_log_in);

        prgPolice = (ProgressBar)findViewById(R.id.progress);
        prgPolice.setVisibility(View.INVISIBLE);
    }
    public void SubmitClicked(View view)
    {
        prgPolice.setVisibility(View.VISIBLE);

        String email;
        String password;
        Memail= (EditText)findViewById(R.id.Email);
        Mpassword = (EditText)findViewById(R.id.Password);

        Snackbar.make(view, "Please wait to verify LogIn", Snackbar.LENGTH_LONG)
                .setAction("Sign in",null).show();

        email=Memail.getText().toString();
        password=Mpassword.getText().toString();
        if(email.equalsIgnoreCase("police@gmail.com") && password.equalsIgnoreCase("iamapolice123"))
        {
            prgPolice.setProgress(25);

            Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    prgPolice.setProgress(80);
                    Intent SuccessLog = new Intent(PoliceLogInActivity.this,PoliceTicketActivty.class);
                    startActivity(SuccessLog);
                }
            },2000);


        }

    }
    public void RegisterClicked(View view)
    {
        Intent RegisterIntent = new Intent(PoliceLogInActivity.this,PoliceRegistrationActivity.class);
        startActivity(RegisterIntent);

    }
}
