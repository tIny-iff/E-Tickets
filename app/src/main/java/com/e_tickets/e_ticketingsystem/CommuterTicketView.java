package com.e_tickets.e_ticketingsystem;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommuterTicketView extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commuter_ticket_view);

    }

    public void ViewTicketClicked(View view)
    {
        Offenderclass offenderclass = new Offenderclass();


        Button vticket = findViewById(R.id.ViewTicket);
        vticket.setVisibility(View.INVISIBLE);

        String Mtrn = "";

        Mtrn=getIntent().getStringExtra("TRN");

        // ImageView profiletest = findViewById(R.id.Image_test);
         //profiletest.setVisibility(View.INVISIBLE);
        de.hdodenhof.circleimageview.CircleImageView profile =(de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.profile_image);
       profile.setVisibility(View.VISIBLE);
        Database database = new Database(this);
        database.execute("Commuter Login",Mtrn);


        try {
            offenderclass=database.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        TextView ocode = findViewById(R.id.Ocode);
        ocode.setVisibility(View.VISIBLE);
        ocode.setText(offenderclass.getOffenseCode());

        ComInfo(ocode.getText().toString());


//        TextView vehicletype = findViewById(R.id.ComVtype);
//        vehicletype.setVisibility(View.VISIBLE);
//        vehicletype.setText(vehicletype.getText()+offenderclass.getVehicleType());




        InputStream inputStream = null;
        try {
            inputStream = offenderclass.getPhoto().getBinaryStream();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException e)
        {
            Toast.makeText(this,"Nothing is there",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast.makeText(this,"Profile image was not updated",Toast.LENGTH_LONG).show();
        }
        profile.setImageBitmap(BitmapFactory.decodeStream(inputStream));
    }

    public void ComInfo(String Offcode)
    {
        String method ="Get ticket info";
        Offenderclass offenderclass = new Offenderclass();

        Database database = new Database(this);
        database.execute(method,Offcode);

        try {
            offenderclass=database.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        TextView offenses = findViewById(R.id.ComOffenses);
        offenses.setVisibility(View.VISIBLE);
        offenses.setText(offenses.getText()+offenderclass.getOffenseCom());

        TextView amount = findViewById(R.id.ComOwed);
        amount.setVisibility(View.VISIBLE);
        amount.setText(offenderclass.getFeeOffense());

        TextView time = findViewById(R.id.ComTime);
        time.setVisibility(View.VISIBLE);
        time .setText(time.getText()+offenderclass.getDate());

        Button finish = findViewById(R.id.Finish);

        finish.setVisibility(View.VISIBLE);
    }

    public void FinishClicked(View view)
    {
        Intent goback = new Intent(CommuterTicketView.this,CommuterLogin.class);
        startActivity(goback);

        Toast.makeText(this, "Logged out of system, Have a nice day",Toast.LENGTH_LONG).show();

    }

}
