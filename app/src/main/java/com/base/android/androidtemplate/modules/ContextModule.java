package com.base.android.androidtemplate.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amey on 3/11/18.
 */

@Module
public class ContextModule
{
    private Context context;

    public ContextModule(Context context)
    {
        this.context = context;
    }

    @Provides
    Context provideContext()
    {
        return context;
    }
}
