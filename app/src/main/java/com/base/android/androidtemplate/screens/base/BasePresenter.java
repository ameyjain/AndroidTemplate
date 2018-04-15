package com.base.android.androidtemplate.screens.base;

/**
 * Created by AmeyJain on 3/12/18.
 */

public abstract class BasePresenter
{
    protected BaseView view;

    public abstract void onCreate();

    public void onDestroy()
    {
        view = null;
    }

    public BasePresenter(BaseView view)
    {
        this.view = view;
    }
}
