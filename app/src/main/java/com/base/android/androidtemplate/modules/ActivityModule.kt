package com.base.android.androidtemplate.modules

import com.base.android.androidtemplate.screens.main.MainActivity
import com.base.android.androidtemplate.screens.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by AmeyJain on 3/23/18.
 */

@Module
class MainActivityModule(private val mainActivity : MainActivity) {

    @Provides fun provideMainPresenter(): MainPresenter = MainPresenter(mainActivity)

    @Provides fun provideMainActivity(): MainActivity = mainActivity
}
