package com.e_tickets.e_ticketingsystem;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommuterLogin extends AppCompatActivity {
    private EditText Mtrn;
    private  EditText Mpassword;


    ProgressBar prgCommuter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commuter_login);
        prgCommuter = (ProgressBar)findViewById(R.id.progress);
        prgCommuter.setVisibility(View.INVISIBLE);
    }

    public void SubmitClicked(final View view)
    {
        prgCommuter.setVisibility(View.VISIBLE);

        final String trn;
        String password;
        Mtrn= (EditText)findViewById(R.id.Email);
        Mpassword = (EditText)findViewById(R.id.Password);

        Snackbar.make(view, "Please wait to verify LogIn", Snackbar.LENGTH_LONG)
                .setAction("Sign in",null).show();

        trn=Mtrn.getText().toString();

        password=Mpassword.getText().toString();

        Database database = new Database(this);
        database.execute("Commuter Login",trn);

        Offenderclass offenderclass = new Offenderclass();
        try {

            offenderclass = database.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if(password.equalsIgnoreCase(offenderclass.getCommuterpass()))
        {


            prgCommuter.setProgress(25);

            final String name = offenderclass.getF_name();

            Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    prgCommuter.setProgress(80);

                    Intent SuccessLog = new Intent(CommuterLogin.this,CommuterTicketView.class);
                    SuccessLog.putExtra("TRN",trn);
                    startActivity(SuccessLog);
                }
            },2000);

            Toast.makeText(this,"Welcome "+name+",to E-tickets :)",Toast.LENGTH_LONG).show();
        }


    }

    public void RegisterClicked(View view)
    {
        Intent regisIntent = new Intent(CommuterLogin.this,CommuterRegistrationActivity.class);
        startActivity(regisIntent);
    }
}
