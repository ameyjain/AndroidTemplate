package com.base.android.androidtemplate;

import android.app.Application;

import com.base.android.androidtemplate.components.AppComponent;
import com.base.android.androidtemplate.components.DaggerAppComponent;
import com.base.android.androidtemplate.modules.ContextModule;


/**
 * Created by Amey on 3/11/18.
 */

public class MyApp extends Application
{
    private AppComponent component;

    @Override
    public void onCreate()
    {
        super.onCreate();
        component = DaggerAppComponent.builder()
                                      .contextModule(new ContextModule(this))
                                      .build();

    }

    public AppComponent getApplicationComponent()
    {
        return component;
    }
}
