package com.e_tickets.e_ticketingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogInOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_options);
    }

    public void PoliceClicked(View view)
    {
        //Button police = (Button)findViewById(R.id.Police);
       // police.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View view) {
                Intent policeIntent = new Intent(LogInOptions.this,PoliceLogInActivity.class);
                startActivity(policeIntent);
            }




    public void CommuterClicked(View view)
    {
        Button cancel = (Button)findViewById(R.id.Cancel);
       // cancel.setOnClickListener(new View.OnClickListener() {

                Intent commuterIntent = new Intent(LogInOptions.this,MainActivity.class);
                startActivity(commuterIntent);
            }




    public void JudiciaryClicked(View view)
    {
        Button cancel = (Button)findViewById(R.id.Cancel);

                Intent judiciaryIntent = new Intent(LogInOptions.this,MainActivity.class);
                startActivity(judiciaryIntent);
            }



}
