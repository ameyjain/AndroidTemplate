package com.base.android.androidtemplate.application;

import android.app.Application;

import com.base.android.androidtemplate.components.DaggerMyApplicationComponent;
import com.base.android.androidtemplate.components.MyApplicationComponent;
import com.base.android.androidtemplate.modules.ContextModule;

/**
 * Created by Amey on 3/11/18.
 */

public class MyApp extends Application
{
    private MyApplicationComponent component;

    @Override
    public void onCreate()
    {
        super.onCreate();
        component = DaggerMyApplicationComponent.builder()
                                                .contextModule(new ContextModule(this))
                                                .build();
    }

    public MyApplicationComponent getApplicationComponent()
    {
        return component;
    }
}
