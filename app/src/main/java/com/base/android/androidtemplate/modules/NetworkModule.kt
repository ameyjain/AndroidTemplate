package com.base.android.androidtemplate.modules

import android.content.Context
import android.util.Log
import com.base.android.androidtemplate.components.MyApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File

/**
 * Created by AmeyJain on 3/23/18.
 */

@Module(includes = arrayOf(ContextModule::class))
class NetworkModule {

    @Provides @MyApplicationScope fun provideLogginInterceptor(): HttpLoggingInterceptor {

        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.d("OkHTTP: ", message) })
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return interceptor
    }

    @Provides
    @MyApplicationScope
    fun cache(cacheFile: File): Cache = Cache(cacheFile, (10 * 1000 * 1000).toLong()) //10MB Cache

    @Provides
    @MyApplicationScope
    fun cacheFile(context: Context): File = File(context.cacheDir, "okhttp_cache")

    @Provides
    @MyApplicationScope
    fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor, cache: Cache):
            OkHttpClient =  OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .cache(cache)
            .build()

}