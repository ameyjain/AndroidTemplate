package com.base.android.androidtemplate.screens.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.base.android.androidtemplate.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView
{

    @Inject SharedPreferences sharedPreferences;
    @Inject MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MainActivityComponent component = DaggerMainActivityComponent.builder().myApplicationComponent(((MyApp) getApplication()).getApplicationComponent()).build();
//        component.inject(this);
    }
}
