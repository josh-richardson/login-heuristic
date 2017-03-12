package com.hackathon.loginriskapp;

import android.app.IntentService;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

/**
 * Created by edge on 11/03/17.
 */

public class LocationService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public LocationService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        while (true) {

            System.out.println("WOOP");

            try {
                wait(30000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }


}
