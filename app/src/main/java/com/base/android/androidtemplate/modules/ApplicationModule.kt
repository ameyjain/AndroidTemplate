package com.base.android.androidtemplate.modules

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides

/**
 * Created by AmeyJain on 3/23/18.
 */

@Module
class ContextModule(val applicationContext : Context) {

    @Provides fun provideContext(): Context = applicationContext
}

@Module(includes = arrayOf(ContextModule::class))
class SharedPrefModule {

    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences =
            context.getSharedPreferences("YOUR_PREF_NAME", Context.MODE_PRIVATE)
}
