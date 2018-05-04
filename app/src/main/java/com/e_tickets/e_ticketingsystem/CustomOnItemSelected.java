package com.e_tickets.e_ticketingsystem;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

/**
 * Created by Kerrs Unit on 23/04/2018.
 */

public class CustomOnItemSelected implements AdapterView.OnItemSelectedListener {
    Offense offenderobj = new Offense();
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

        switch (position)
        {
            case 0:


                break;

            case 1:




                Toast.makeText(adapterView.getContext(),"Points deducted would be:2",Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
