package com.base.android.androidtemplate.modules;

import com.base.android.androidtemplate.components.PerActivity;
import com.base.android.androidtemplate.screens.base.BaseView;
import com.base.android.androidtemplate.screens.login.LoginPresenter;
import com.base.android.androidtemplate.screens.login.LoginView;
import com.base.android.androidtemplate.screens.main.MainPresenter;
import com.base.android.androidtemplate.screens.main.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AmeyJain on 3/12/18.
 */

@Module
public class BaseActivityModule
{
    private BaseView view;

    public BaseActivityModule(BaseView view)
    {
        this.view = view;
    }

    @Provides
    @PerActivity
    MainPresenter providesMainPresenter()
    {
        return new MainPresenter((MainView) view);
    }

    @Provides
    @PerActivity
    LoginPresenter providesLoginPresenter()
    {
        return new LoginPresenter((LoginView) view);
    }
}
