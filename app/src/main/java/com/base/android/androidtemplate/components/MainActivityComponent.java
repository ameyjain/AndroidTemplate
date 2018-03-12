package com.base.android.androidtemplate.components;

import com.base.android.androidtemplate.modules.MainActivityModule;
import com.base.android.androidtemplate.screens.main.MainActivity;

import dagger.Component;

/**
 * Created by AmeyJain on 3/12/18.
 */

@PerActivity
@Component(modules = MainActivityModule.class, dependencies = MyApplicationComponent.class)
public interface MainActivityComponent
{
    void inject(MainActivity mainActivity);
}
