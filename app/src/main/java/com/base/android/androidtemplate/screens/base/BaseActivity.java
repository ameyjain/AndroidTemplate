package com.base.android.androidtemplate.screens.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.base.android.androidtemplate.application.MyApp;
import com.base.android.androidtemplate.components.BaseActivityComponent;
import com.base.android.androidtemplate.components.DaggerBaseActivityComponent;
import com.base.android.androidtemplate.modules.BaseActivityModule;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity implements BaseView
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState)
    {
        super.onCreate(savedInstanceState, persistentState);
        BaseActivityComponent component = DaggerBaseActivityComponent.builder()
                .myApplicationComponent(((MyApp) getApplication()).getApplicationComponent())
                .baseActivityModule(new BaseActivityModule(this))
                .build();
        component.inject(this);
    }
}
