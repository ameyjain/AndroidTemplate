package com.base.android.androidtemplate.modules;

import com.base.android.androidtemplate.components.PerActivity;
import com.base.android.androidtemplate.screens.main.MainPresenter;
import com.base.android.androidtemplate.screens.main.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AmeyJain on 3/12/18.
 */

@Module
public class MainActivityModule
{
    MainView view;

    public MainActivityModule(MainView view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    MainPresenter providesMainPresenter()
    {
        return new MainPresenter(view);
    }
}
