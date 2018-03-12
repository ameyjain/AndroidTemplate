package com.base.android.androidtemplate.screens.main;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.base.android.androidtemplate.MyApp;
import com.base.android.androidtemplate.R;
import com.base.android.androidtemplate.components.DaggerMainActivityComponent;
import com.base.android.androidtemplate.components.MainActivityComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView
{

    @Inject SharedPreferences sharedPreferences;
    @Inject MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityComponent component = DaggerMainActivityComponent.builder().myApplicationComponent(((MyApp) getApplication()).getApplicationComponent()).build();
        component.inject(this);
    }
}
