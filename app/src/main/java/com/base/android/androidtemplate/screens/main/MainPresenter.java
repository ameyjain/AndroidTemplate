package com.base.android.androidtemplate.screens.main;

import com.base.android.androidtemplate.screens.PresenterHelper;

/**
 * Created by AmeyJain on 3/12/18.
 */

public class MainPresenter implements PresenterHelper
{
    private MainView view;

    public MainPresenter(MainView view)
    {
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
