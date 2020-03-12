package edu.phoenixforce.scouting.mobile.layouts;

import android.app.Application;

public class ScoutingApplication extends Application {

    @Override
    public void onCreate() {
        Configuration.getInstance(getApplicationContext());
        super.onCreate();



    }
}
