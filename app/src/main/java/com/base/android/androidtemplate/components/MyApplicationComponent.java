package com.base.android.androidtemplate.components;

import android.content.SharedPreferences;

import com.base.android.androidtemplate.modules.MyRetrofitServiceModule;
import com.base.android.androidtemplate.modules.PicassoModule;
import com.base.android.androidtemplate.modules.SharedPrefModule;
import com.base.android.androidtemplate.network.MyRetrofitService;
import com.base.android.androidtemplate.screens.main.MainActivity;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Amey on 3/11/18.
 */

@MyApplicationScope
@Component(modules = {PicassoModule.class, MyRetrofitServiceModule.class, SharedPrefModule.class})
public interface MyApplicationComponent
{
    Picasso getPicasso();

    MyRetrofitService getRetrofitService();

    SharedPreferences getSharedPreference();
}
