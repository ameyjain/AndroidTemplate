package com.base.android.androidtemplate.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.base.android.androidtemplate.components.MyApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AmeyJain on 3/12/18.
 */

@Module(includes = ContextModule.class)
public class SharedPrefModule
{
    @Provides
    @MyApplicationScope
    SharedPreferences provideSharedPreferences(Context context)
    {
        return context.getSharedPreferences("YOUR_PREF_NAME", Context.MODE_PRIVATE);
    }
}
