package com.example.mysamll.app.locationmanage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    final String TAG = "MA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager locationManager = (LocationManager) this.getSystemService(this.LOCATION_SERVICE);
        LocationProvider provider =
                locationManager.getProvider(LocationManager.GPS_PROVIDER);

        LocationListener locationListener =new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.i(TAG+"getLongitude:",Double.toString(location.getLongitude()));
                Log.i(TAG+"getLatitude:",Double.toString(location.getLatitude()));
                Log.i(TAG+"getAltitude:",Double.toString(location.getAltitude()));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(this.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG+":","onStart()");

        LocationListener locationListener =new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //经度
                Log.i(TAG+"getLongitude:",Double.toString(location.getLongitude()));
                //维度
                Log.i(TAG+"getLatitude:",Double.toString(location.getLatitude()));
                //海拔
                Log.i(TAG+"getAltitude:",Double.toString(location.getAltitude()));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if((this.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)){
                LocationManager locationManager = (LocationManager) this.getSystemService(this.LOCATION_SERVICE);
                boolean isOpen = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                Log.i(TAG+"isOpen:",Boolean.toString(isOpen));
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,10,locationListener);
            }
        }

    }
}
