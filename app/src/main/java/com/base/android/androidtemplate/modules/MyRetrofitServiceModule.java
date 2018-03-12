package com.base.android.androidtemplate.modules;

import com.base.android.androidtemplate.network.MyRetrofitService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * All the retrofit service related dependencies go here
 *
 * Created by Amey on 3/11/18.
 */

@Module(includes = NetworkModule.class)
public class MyRetrofitServiceModule
{
    @Provides
    MyRetrofitService providesMyRetrofitService(Retrofit myRetrofit)
    {
        return myRetrofit.create(MyRetrofitService.class);
    }

    @Provides
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient)
    {
         return new Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .client(okHttpClient)
                            .baseUrl("https://YOUR_BASE_URL")
                            .build();
    }

    @Provides
    Gson provideGson()
    {
        return new GsonBuilder().create();
    }
}
