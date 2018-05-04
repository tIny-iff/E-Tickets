package com.e_tickets.e_ticketingsystem;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class PoliceTicketActivty extends AppCompatActivity {

    private Offenderclass offender = new Offenderclass();
   // private Offense offenderobj = new Offense();
    private static String Offensescommit = "";
    private RadioGroup OffenseR;
    private RadioButton button;
    private Connection connection;
    private TextView offenses;
    private static int feeSum = 0;
    private static int pointsSum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_ticket_activty);
    }


    public void EnterClicked(View view) {

        Snackbar.make(view, "Connecting to servers", Snackbar.LENGTH_LONG)
                .setAction("Servers", null).show();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                TextView trn = findViewById(R.id.TRN);

                Button enter = findViewById(R.id.Enter);
                //TextView offView = findViewById(R.id.Offenses);
                //offView.setVisibility(View.VISIBLE);
                enter.setVisibility(View.GONE);
                if (trn != null) {


                    String TRN = trn.getText().toString();
                    Offenderclass off1 = new Offenderclass();
                    off1 = CreatConnection(TRN);



                    TextView vehicletype = findViewById(R.id.Vehicletype);
                    TextView vehicleowner = findViewById(R.id.VehicleOwner);
                    TextView vehiclemake = findViewById(R.id.Vehiclemake);
                    TextView vehiclemodel = findViewById(R.id.VehicleModel);

                    vehiclemake.setVisibility(View.VISIBLE);
                    vehicletype.setVisibility(View.VISIBLE);
                    vehicleowner.setVisibility(View.VISIBLE);
                    vehiclemodel.setVisibility(View.VISIBLE);


                    TextView vehicleregnum = findViewById(R.id.licensePlnum);
                    vehicleregnum.setVisibility(View.VISIBLE);
                    vehicleregnum.setText(vehicleregnum.getText()+Integer.toString(off1.getVehicleRegnum()));

                    TextView fname = findViewById(R.id.fname);
                    fname.setText(fname.getText() + off1.getF_name());
                    fname.setVisibility(View.VISIBLE);

                    TextView lname = findViewById(R.id.lname);
                    lname.setText(lname.getText() + off1.getL_name());
                    lname.setVisibility(View.VISIBLE);

                    TextView email = findViewById(R.id.commuterEmail);
                    email.setText(email.getText() + off1.getEmail());
                    email.setVisibility(View.VISIBLE);


                    TextView gender = findViewById(R.id.gender);
                    gender.setText(gender.getText() + off1.getGender());
                    gender.setVisibility(View.VISIBLE);





                    TextView locationview = findViewById(R.id.Location);
                    String location = locationview.getText().toString();


                    // RadioListen();
                    vehicleInfo(Integer.toString(off1.getVehicleRegnum()));
                }
                //Intent SuccessLog = new Intent(PoliceLogInActivity.this,PoliceTicketActivty.class);
                //startActivity(SuccessLog);
            }
        }, 2000);





    }



    public void CheckboxClicked(View view) {

        boolean checked = ((CheckBox) view ).isChecked();

        switch(view.getId())
        {
            case R.id.silent:
                if(checked)
                {
                    Offensescommit=Offensescommit+"disrupting silent zone,";
                    feeSum=feeSum+5000;
                    pointsSum=pointsSum+2;
                }break;
            case R.id.speed32:
                if(checked)
                {
                    Offensescommit=Offensescommit+"Speeding by 16 to 32 mph,";

                    feeSum=feeSum+12000;
                    pointsSum=pointsSum+4;
                }break;
            case R.id.speed50:
                if(checked)
                {
                    Offensescommit=Offensescommit+"Speeding by >= 50 mph,";
                    feeSum=feeSum+30000;
                    pointsSum=pointsSum+6;
                }
            case R.id.Rdriving:
                if(checked)
                {
                    Offensescommit=Offensescommit+"Dangerous driving,";
                    feeSum=feeSum+11000;
                    pointsSum=pointsSum+14;
                }break;
            case R.id.noSeatbelt:
                if(checked)
                {
                    Offensescommit=Offensescommit+"Driving without seatbelt,";
                    feeSum=feeSum+2000;
                    pointsSum=pointsSum+2;
                }break;

            case R.id.Overtaking:
                if(checked)
                {
                    Offensescommit=Offensescommit+"Reckless overtaking ,";
                    feeSum=feeSum+9000;
                    pointsSum=pointsSum+6;
                }break;
            case R.id.Tlight:
                if(checked)
                {
                    Offensescommit=Offensescommit+"Failure to adhere to traffic light,";
                    feeSum=feeSum+10000;
                    pointsSum=pointsSum+6;
                }break;

        }
//

    }

    public void vehicleInfo(String trn) {
        String method = "Vehicle Info";

        Database database = new Database(this);
        database.execute(method, trn);

        try {
            offender = database.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


                TextView vehicletype = findViewById(R.id.Vehicletype);
                TextView vehicleowner = findViewById(R.id.VehicleOwner);
                TextView vehiclemake = findViewById(R.id.Vehiclemake);
                TextView vehiclemodel = findViewById(R.id.VehicleModel);

                vehiclemake.setText(vehiclemake.getText()+offender.getMake());
                vehicleowner.setText(vehicleowner.getText()+offender.getOwner());
                vehicletype.setText(vehicletype.getText()+offender.getVehicleType());
                vehiclemodel.setText(vehiclemodel.getText()+offender.getModel());

                Toast.makeText(this, "Vehicle Info Retrieved", Toast.LENGTH_SHORT).show();

    }



    public Offenderclass CreatConnection(String trn) {
        String method = "TicketMethod";
        Database database = new Database(this);
        database.execute(method, trn);
        try {
            this.offender = database.get();
            Toast.makeText(this,"Connected again",Toast.LENGTH_LONG).show();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



//        TextView LicensePlnum = findViewById(R.id.licensePlnum);
//        LicensePlnum.setText(LicensePlnum.getText() + Integer.toString(offender.getVehicleRegnum()));
//        LicensePlnum.setVisibility(View.VISIBLE);

        InputStream inputStream = null;
        try {

            inputStream = this.offender.getPhoto().getBinaryStream();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            Toast.makeText(this, "Nothing is there", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Profile image was not updated", Toast.LENGTH_LONG).show();
        }
        ImageView ticketimg = findViewById(R.id.policeimg);
        ticketimg.setImageBitmap(BitmapFactory.decodeStream(inputStream));

        return offender;
    }



    public void LocationClicked(View view)
    {
        Intent LocationView = new Intent(PoliceTicketActivty.this,MapsActivity.class);
        startActivity(LocationView);
    }

    public void TicketClicked(View view)
    {
        TextView fname = findViewById(R.id.fname);
        TextView lname = findViewById(R.id.lname);
        TextView email = findViewById(R.id.commuterEmail);
        TextView address = findViewById(R.id.Streetname);
        TextView gender = findViewById(R.id.gender);
        TextView vehicleReg = findViewById(R.id.licensePlnum);
        TextView vehicletype = findViewById(R.id.Vehicletype);
        TextView vehicleowner = findViewById(R.id.VehicleOwner);
        TextView vehiclemake = findViewById(R.id.Vehiclemake);
        TextView vehiclemodel = findViewById(R.id.VehicleModel);

        String badgenum=getIntent().getStringExtra("Badgenum");

        Date c = Calendar.getInstance().getTime();
        System.out.print("Current time:"+c);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MMM-dd");
        String date = df.format(c);
    String ticketData = "";





        ticketData=fname.getText()+"\n"+lname.getText()+"\n"+email.getText()+"\n"+gender.getText()
                +"\n"+vehicleReg.getText()+"\n"+",Offenses commited:"+Offensescommit+"\t"+
                "\tFees owed:"+feeSum+"\n"+"\t"+",Points to be deducted:"
                +pointsSum+"Vehicle make:"+vehiclemake.getText().toString()+
                ","+vehicleowner.getText().toString()+
                ","+vehiclemodel.getText().toString()+","+vehicletype.getText().toString()+
                "\t,Issued at:"+date+"\t ,Address issued:"+address.getText().toString()+" " +
                ",Police badgenum:"+badgenum;

        Offenderclass OffUpdate = new Offenderclass();
        OffUpdate.setAddress(address.getText().toString());
        OffUpdate.setOffenseCom(Offensescommit);
        OffUpdate.setMake(vehiclemake.getText().toString());
        OffUpdate.setModel(vehiclemodel.getText().toString());
        OffUpdate.setOwner(vehicleowner.getText().toString());
        OffUpdate.setFees(feeSum);
        OffUpdate.setBadgeNum(badgenum);
        OffUpdate.setPoints(pointsSum);
        OffUpdate.setDate(date);

        AddToDatabaseBackground addToDatabaseBackground = new AddToDatabaseBackground();
        addToDatabaseBackground.execute(OffUpdate);

        try {
            String statusUpdate= addToDatabaseBackground.get();
            System.out.print(statusUpdate);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        final SendEmail sendEmail =new SendEmail();
        sendEmail.setEmailData("trevidlas@gmail.com","Ticket",ticketData);
        sendEmail.execute();
        try {
            String status=sendEmail.get();
            System.out.println("Email status:"+status);
            if(status.equalsIgnoreCase("Email was sent"))
            {
                Toast.makeText(this,"Ticket was issued to commuter, logging out...",Toast.LENGTH_LONG).show();
                Intent logout = new Intent(PoliceTicketActivty.this,PoliceLogInActivity.class);
                startActivity(logout);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
