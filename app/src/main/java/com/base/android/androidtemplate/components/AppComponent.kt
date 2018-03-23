package com.base.android.androidtemplate.components

import android.content.SharedPreferences
import com.base.android.androidtemplate.modules.ContextModule
import com.base.android.androidtemplate.modules.MyRetrofitServiceModule
import com.base.android.androidtemplate.modules.PicassoModule
import com.base.android.androidtemplate.modules.SharedPrefModule
import com.base.android.androidtemplate.network.MyRetrofitService
import com.squareup.picasso.Picasso
import dagger.Component
import javax.inject.Scope

/**
 * Created by AmeyJain on 3/23/18.
 */

@MyApplicationScope
@Component(modules = arrayOf(PicassoModule::class, MyRetrofitServiceModule::class, ContextModule::class, SharedPrefModule::class))
interface AppComponent {

    val picasso: Picasso

    val retrofitService: MyRetrofitService

    val sharedPreference: SharedPreferences
}

@Scope
annotation class MyApplicationScope
