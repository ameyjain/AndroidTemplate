package com.base.android.androidtemplate.components;

import com.base.android.androidtemplate.modules.BaseActivityModule;
import com.base.android.androidtemplate.screens.base.BaseActivity;
import com.base.android.androidtemplate.screens.login.LoginPresenter;
import com.base.android.androidtemplate.screens.main.MainPresenter;

import dagger.Component;

/**
 * Created by AmeyJain on 3/12/18.
 */

@PerActivity
@Component(modules = BaseActivityModule.class, dependencies = MyApplicationComponent.class)
public interface BaseActivityComponent
{
    void inject(BaseActivity activity);

    MainPresenter getMainPresenter();

    LoginPresenter getLoginPresenter();
}
