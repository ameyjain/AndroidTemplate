package com.base.android.androidtemplate.screens.main;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.base.android.androidtemplate.R;
import com.base.android.androidtemplate.screens.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView
{
    @Inject SharedPreferences sharedPreferences;
    @Inject MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
