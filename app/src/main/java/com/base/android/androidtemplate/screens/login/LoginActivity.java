package com.base.android.androidtemplate.screens.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.base.android.androidtemplate.R;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter.onCreate();
    }
}
