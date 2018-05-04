package com.e_tickets.e_ticketingsystem;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class CommuterRegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commuter_registration);
    }

    public void C_SubmitClicked(View view)
    {
        EditText Com_trn = findViewById(R.id.C_Trn);

        EditText Com_Fname = findViewById(R.id.C_Fname);

        EditText Com_Lname = findViewById(R.id.C_Lname);

        EditText Com_Mname = findViewById(R.id.C_Mname);

        EditText Com_Pass= findViewById(R.id.C_Password);

        Offenderclass offenderclass = new Offenderclass();

        offenderclass.setTRN(Com_trn.getText().toString());
        offenderclass.setFname(Com_Fname.getText().toString());
        offenderclass.setL_name(Com_Lname.getText().toString());
        offenderclass.setMid_name(Com_Mname.getText().toString());
        offenderclass.setCommuterpass(Com_Pass.getText().toString());

        CommuterRegistrationDatabase Com_database = new CommuterRegistrationDatabase();
        Com_database.execute(offenderclass);

        String status = "";

        try {
            status=Com_database.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (status.equalsIgnoreCase("Servers Updated successfully")) {
            Toast.makeText(this,"Registration was successful",Toast.LENGTH_LONG).show();
            Intent RegisteredIntent = new Intent(CommuterRegistrationActivity.this, CommuterLogin.class);
            startActivity(RegisteredIntent);
        }
    }


}

