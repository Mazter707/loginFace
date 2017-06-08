package com.mazter707.appreferences;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;


/**
 * Created by LAP on 6/7/2017.
 */

public class GoogleAnalyticsApplication extends Application {
    private Tracker mTracker;

    synchronized public Tracker getDefaultTracker(){
        if(mTracker == null){
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            mTracker=analytics.newTracker(R.xml.analytics_tracker);
        }
        return mTracker;
    }

}
