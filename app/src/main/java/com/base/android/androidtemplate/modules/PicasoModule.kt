package com.base.android.androidtemplate.modules

import android.content.Context
import com.base.android.androidtemplate.components.MyApplicationScope
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

/**
 * Created by AmeyJain on 3/23/18.
 */

@Module(includes = arrayOf(ContextModule::class, NetworkModule::class))
class PicassoModule {

    @Provides
    @MyApplicationScope
    fun picasso(context: Context, okHttp3Downloader: OkHttp3Downloader):
            Picasso = Picasso.Builder(context)
            .downloader(okHttp3Downloader)
            .build()

    @Provides
    @MyApplicationScope
    fun okHttp3Downloader(okHttpClient: OkHttpClient): OkHttp3Downloader = OkHttp3Downloader(okHttpClient)

}