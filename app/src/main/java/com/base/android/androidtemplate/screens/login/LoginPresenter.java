package com.base.android.androidtemplate.screens.login;

import com.base.android.androidtemplate.screens.base.BasePresenter;

public class LoginPresenter extends BasePresenter
{

    public LoginPresenter(LoginView view)
    {
        super(view);
        this.view = view;
    }

    @Override
    public void onCreate()
    {

    }

    @Override
    public void onDestroy()
    {
        view = null;
    }
}