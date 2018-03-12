package com.base.android.androidtemplate;

import android.app.Application;

import com.base.android.androidtemplate.components.MyApplicationComponent;
import com.base.android.androidtemplate.models.ContextModule;

/**
 * Created by Amey on 3/11/18.
 */

public class MyApp extends Application
{
    MyApplicationComponent component;

    @Override
    public void onCreate()
    {
        super.onCreate();
    }
}
