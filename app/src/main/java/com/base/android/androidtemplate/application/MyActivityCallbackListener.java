package com.base.android.androidtemplate.application;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;

import com.base.android.androidtemplate.receivers.NetworkStateReceiver;

public class MyActivityCallbackListener implements Application.ActivityLifecycleCallbacks
{
    private BroadcastReceiver networkStateReceiver = NetworkStateReceiver.getINSTANCE();

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle)
    {
        activity.registerReceiver(networkStateReceiver,
                new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity)
    {
        activity.unregisterReceiver(networkStateReceiver);
    }
}
