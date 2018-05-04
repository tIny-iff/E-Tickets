package com.e_tickets.e_ticketingsystem;

import android.content.Intent;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class PoliceLogInActivity extends AppCompatActivity {

    private  EditText Mbadge;
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

        final String badgenum;
        String password;
        Mbadge = (EditText)findViewById(R.id.Email);
        Mpassword = (EditText)findViewById(R.id.Password);

        Snackbar.make(view, "Please wait to verify LogIn", Snackbar.LENGTH_LONG)
                .setAction("Sign in",null).show();

        badgenum=Mbadge.getText().toString();
        password=Mpassword.getText().toString();
        SHAHashing hash = new SHAHashing();

        System.out.println("Hashed as:"+hash.hashPassword(password));

        Database database = new Database(this);
        database.execute("Police Login",badgenum);

        Offenderclass offenderclass = new Offenderclass();

        try {
            offenderclass = database.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if(password.equalsIgnoreCase(offenderclass.getPolice_pass()))
        {
            prgPolice.setProgress(25);

            Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    prgPolice.setProgress(80);
                    Intent SuccessLog = new Intent(PoliceLogInActivity.this,PoliceTicketActivty.class);
                    SuccessLog.putExtra("Badgenum",badgenum);
                    startActivity(SuccessLog);
                }
            },2000);


        }else{
            prgPolice.setVisibility(View.INVISIBLE);
            Snackbar.make(view, "Incorrect credentials entered!", Snackbar.LENGTH_LONG)
                    .setAction("Warning",null).show();
        }

    }
    public void RegisterClicked(View view)
    {
        Intent RegisterIntent = new Intent(PoliceLogInActivity.this,PoliceRegistrationActivity.class);
        startActivity(RegisterIntent);

    }
}
