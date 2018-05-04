package com.e_tickets.e_ticketingsystem;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    LocationManager locationManager;

    Button btnShowLocation;

  //  private static final int REQUEST_CODE_PERMISSION=2;

    String mPermission;

    {
        mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    }

    TextView locationtxt;



    @Override //Initialising of an activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        final Button btnShowLocation= (Button) findViewById(R.id.mapbutton);
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                btnShowLocation.setVisibility(view.GONE);
                Snackbar.make(view, "Click police icon to get street name", Snackbar.LENGTH_LONG)
                        .setAction("Location",null).show();
                if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }

                locationtxt =(TextView)  findViewById(R.id.locationText);
                if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            double latitude = location.getLatitude();

                            double longitude = location.getLongitude();

                            locationtxt.setText(location.getLatitude() + "" + location.getLongitude());

                            LatLng latLng = new LatLng(latitude, longitude);

                            Geocoder geocoder = new Geocoder(getApplicationContext());
                            try {
                                
                                List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                                String name = addressList.get(0).getThoroughfare()+","+addressList.get(0).getLocality() + ",";
                                name += addressList.get(0).getCountryName();
                                //mMap.addMarker(new MarkerOptions().position(latLng).title(name).icon(BitmapDescriptorFactory.fromResource(R.drawable.police)));
                                MarkerOptions marker = new MarkerOptions().position(latLng).title(name);
                                marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.policeshield));
                               mMap.clear();

                               if(addressList.get(0).getThoroughfare()=="null")
                               {
                                   Toast.makeText(MapsActivity.this,"Street name cannot be generated please manually enter on Ticket",Toast.LENGTH_LONG).show();
                                   Intent ticket = new Intent(MapsActivity.this,PoliceTicketActivty.class);
                                   ticket.addFlags(ticket.FLAG_ACTIVITY_CLEAR_TOP);
                                   startActivity(ticket);
                               }

                                mMap.addMarker(marker);

                                //mMap.addMarker(new MarkerOptions().position(latLng).title(name));
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20.2f));

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }


                        @Override
                        public void onStatusChanged(String s, int i, Bundle bundle) {

                        }

                        @Override
                        public void onProviderEnabled(String s) {

                        }

                        @Override
                        public void onProviderDisabled(String s) {

                        }
                    });
                }//Checks




                // if GPS provider is enabled
                else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            //gets current latitude
                            double latitude = location.getLatitude();
                            //gets current longitude
                            double longitude = location.getLongitude();

                            LatLng latLng = new LatLng(latitude, longitude);

                            Geocoder geocoder = new Geocoder(getApplicationContext());
                            try {

                                List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                                String name = addressList.get(0).getCountryName() + ",";
                                name += addressList.get(0).getLocality();

                                mMap.addMarker(new MarkerOptions().position(latLng).title(name));
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20.2f));

                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onStatusChanged(String s, int i, Bundle bundle) {

                        }

                        @Override
                        public void onProviderEnabled(String s) {

                        }

                        @Override
                        public void onProviderDisabled(String s) {

                        }
                    });
                } else ShowsettingAlert();
            }

        });
    }


            //if the Location Services are not enabled they will be prompted to do so
            public void ShowsettingAlert() {
        //Geocoder geocoder = new Geocoder(getApplicationContext());
                AlertDialog.Builder alertdialog = new AlertDialog.Builder(MapsActivity.this);
                alertdialog.setTitle("GPS setting");

                alertdialog.setMessage("GPS is not enabled. Please see settings");

                alertdialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        MapsActivity.this.startActivity(intent);
                    }
                });

                alertdialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        stopGPS();
                    }
                });

                alertdialog.show();

            }

            public void stopGPS() {
                if (locationManager != null) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    locationManager.removeUpdates((LocationListener) MapsActivity.this);
                }
            }


            /**
             * Manipulates the map once available.
             * This callback is triggered when the map is ready to be used.
             * This is where we can add markers or lines, add listeners or move the camera. In this case,
             * we just add a marker near Sydney, Australia.
             * If Google Play services is not installed on the device, the user will be prompted to install
             * it inside the SupportMapFragment. This method will only be triggered once the user has
             * installed Google Play services and returned to the app.
             */
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                // LatLng sydney = new LatLng(18.10696, 77.2975);

                //MarkerOptions a = new MarkerOptions().position(sydney).title("Yard");
                //mMap.addMarker(a);
                //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,10.2f));
                //mMap.(new LatLng(50,5));
                // Add a marker in Sydney and move the camera
                // LatLng sydney = new LatLng(-34, 151);
                //.addMarker(new MarkerOptions().position(new LatLng(18.10696, 77.2975)).title("New Marker"));
                //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            }

}
