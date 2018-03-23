package com.base.android.androidtemplate.modules

import android.content.Context
import com.base.android.androidtemplate.components.MyApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by AmeyJain on 3/23/18.
 */

@Module
class ContextModule(val applicationContext : Context) {

    @Provides
    @MyApplicationScope
    fun provideContext(): Context = applicationContext
}
