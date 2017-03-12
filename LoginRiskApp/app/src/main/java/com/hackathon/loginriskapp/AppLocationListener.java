package com.hackathon.loginriskapp;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/**
 * Created by edge on 12/03/17.
 */

public class AppLocationListener implements LocationListener {
    @Override
    public void onLocationChanged(final Location loc) {
        System.out.println("Location changed");

        new HttpRequestTask().execute("http://192.168.43.170:8080/echo", "{location: { lat: " + loc.getLatitude() + ", long: " + loc.getLongitude() + "}}");
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
}
