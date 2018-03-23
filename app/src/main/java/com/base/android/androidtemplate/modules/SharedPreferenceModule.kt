package com.base.android.androidtemplate.modules

import android.content.Context
import android.content.SharedPreferences
import com.base.android.androidtemplate.components.MyApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by AmeyJain on 3/23/18.
 */

@Module(includes = arrayOf(ContextModule::class))
class SharedPreferenceModule {

    @Provides
    @MyApplicationScope
    fun provideSharedPreferences(context: Context): SharedPreferences =
            context.getSharedPreferences("YOUR_PREF_NAME", Context.MODE_PRIVATE)
}
