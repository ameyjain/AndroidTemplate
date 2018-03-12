package com.base.android.androidtemplate.components;

import com.base.android.androidtemplate.models.MyRetrofitServiceModule;
import com.base.android.androidtemplate.models.PicassoModule;
import com.base.android.androidtemplate.network.MyRetrofitService;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Amey on 3/11/18.
 */

@Component(modules = {PicassoModule.class, MyRetrofitServiceModule.class})
public interface MyApplicationComponent
{
    Picasso getPicasso();

    MyRetrofitService getRetrofitService();
}
