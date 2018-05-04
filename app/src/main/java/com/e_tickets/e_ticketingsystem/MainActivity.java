package com.e_tickets.e_ticketingsystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
private Connection connection = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final LocationManager manager = (LocationManager) getSystemService( MainActivity.LOCATION_SERVICE );

        if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
            ShowsettingAlert();
        }

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Contact us", Snackbar.LENGTH_LONG)
                        .setAction("Action",null).show();

                Intent contactIntent = new Intent(MainActivity.this,ContactUs.class);
                startActivity(contactIntent);
            }
        });

//        BackgroundTask backgroundTask = new BackgroundTask();
//        backgroundTask.execute();
//
//        try{
//            this.connection=backgroundTask.get();
//            if(this.connection != null)
//            {
//                Toast.makeText(this,"The connection a work check your code me g",Toast.LENGTH_SHORT).show();
//            }
//        }catch(NullPointerException e)
//        {
//            Toast.makeText(this,"NTN IS THERE",Toast.LENGTH_LONG).show();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }



        DatabaseFactory databaseFactory = new DatabaseFactory();
        databaseFactory.execute();

        try {
            Connection connection = databaseFactory.get();

            if (connection == null) {
                Toast.makeText(this, "No Connection!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Connection was successful!", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

    }
    public void WelcomeClicked(View view)
    {

        Intent welcomeIntent = new Intent(MainActivity.this,LogInOptions.class);
        startActivity(welcomeIntent);
    }

    public void ShowsettingAlert() {
        //Geocoder geocoder = new Geocoder(getApplicationContext());
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
        alertdialog.setTitle("GPS setting");

        alertdialog.setMessage("GPS is not enabled. Please see settings");

        alertdialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                MainActivity.this.startActivity(intent);
            }
        });

        alertdialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                //stopGPS();
            }
        });

        alertdialog.show();
    }
}
