package com.base.android.androidtemplate.components

import com.base.android.androidtemplate.modules.MainActivityModule
import com.base.android.androidtemplate.screens.main.MainActivity
import dagger.Component
import javax.inject.Scope

/**
 * Created by AmeyJain on 3/23/18.
 */

@PerActivity
@Component(modules = arrayOf(MainActivityModule::class), dependencies = arrayOf(MyApplicationComponent::class))
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}

@Scope
annotation class PerActivity
