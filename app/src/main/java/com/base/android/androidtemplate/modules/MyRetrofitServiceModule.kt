package com.base.android.androidtemplate.modules

import com.base.android.androidtemplate.network.MyRetrofitService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by AmeyJain on 3/23/18.
 */

@Module(includes = arrayOf(ContextModule::class))
class MyRetrofitServiceModule {

    @Provides fun provideMyRetrofitService(myRetrofit : Retrofit):
            MyRetrofitService = myRetrofit.create(MyRetrofitService::class.java)

    @Provides fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient):
            Retrofit =  Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .baseUrl("https:/YOUR_BASE_URL")
            .build()

    @Provides fun provideGson(): Gson = GsonBuilder().create()
}