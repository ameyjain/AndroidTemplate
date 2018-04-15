package com.base.android.androidtemplate.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;

import com.base.android.androidtemplate.R;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.BehaviorSubject;

public class NetworkStateReceiver extends BroadcastReceiver
{

    //==============================================================================================
    // Class Properties
    //==============================================================================================

    public enum NetworkState
    {
        CONNECTED,
        DISCONNECTED
    }

    private static NetworkStateReceiver INSTANCE = null;
    /**
     * Use this observable if you want to do anything when network state changes
     */
    private final BehaviorSubject<NetworkState> networkStateSubject = BehaviorSubject.create();
    private AlertDialog networkLostWarningDialog;
    private NetworkState lastNetworkState;

    //==============================================================================================
    // Static Class Methods
    //==============================================================================================

    public static NetworkStateReceiver getINSTANCE()
    {

        if (INSTANCE == null)
        {
            INSTANCE = new NetworkStateReceiver();
        }

        return INSTANCE;

    }

    //==============================================================================================
    // BroadcastReceiver Implementation
    //==============================================================================================

    @Override
    public void onReceive(Context context, Intent intent)
    {

        if(intent == null || intent.getExtras() == null)
        {
            return;
        }

        ConnectivityManager manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED)
        {
            onNetworkConnected();
        }
        else if(intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,Boolean.FALSE))
        {
            onNetworkDisconnected(context);
        }

    }

    //==============================================================================================
    // Class Instance Methods
    //==============================================================================================

    public Observable<NetworkState> getNetworkState()
    {
        return networkStateSubject.observeOn(AndroidSchedulers.mainThread());
    }

    private void onNetworkConnected()
    {
        NetworkState newNetworkState = NetworkState.CONNECTED;

        if (shouldNotifyOfNetworkStateChange(newNetworkState))
        {
            lastNetworkState = newNetworkState;
            networkStateSubject.onNext(NetworkState.CONNECTED);

            if (networkLostWarningDialog != null)
            {
                networkLostWarningDialog.dismiss();
            }
        }

    }

    private void onNetworkDisconnected(Context context)
    {

        NetworkState newNetworkState = NetworkState.DISCONNECTED;

        if (shouldNotifyOfNetworkStateChange(newNetworkState))
        {
            lastNetworkState = newNetworkState;
            networkStateSubject.onNext(NetworkState.DISCONNECTED);
            showNetworkLostDialog(context);
        }

    }

    private boolean shouldNotifyOfNetworkStateChange(NetworkState newNetworkState)
    {
        return lastNetworkState != newNetworkState;
    }

    private void showNetworkLostDialog(Context context)
    {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        networkLostWarningDialog =
                alertDialogBuilder.setTitle(R.string.dialog_error_title_internet_connectivity)
                        .setMessage(R.string.dialog_default_error_message_interney_connectivity)
                        .setNeutralButton(android.R.string.ok, null)
                        .create();

        networkLostWarningDialog.show();

    }

}