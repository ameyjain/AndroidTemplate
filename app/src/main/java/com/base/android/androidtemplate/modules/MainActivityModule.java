package com.base.android.androidtemplate.modules;

import com.base.android.androidtemplate.screens.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AmeyJain on 3/12/18.
 */

@Module
public class MainActivityModule
{
    @Provides
    MainPresenter providesMainPresenter()
    {
        return new MainPresenter();
    }
}
