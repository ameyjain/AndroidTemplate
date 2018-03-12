package com.base.android.androidtemplate.modules;

import android.content.Context;
import android.util.Log;

import com.base.android.androidtemplate.components.MyApplicationScope;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Amey on 3/11/18.
 */

@Module(includes = ContextModule.class)
public class NetworkModule
{
    @Provides
    @MyApplicationScope
    public HttpLoggingInterceptor loggingInterceptor()
    {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger()
        {
            @Override
            public void log(String message)
            {
                Log.d("OkHTTP: ", message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @Provides
    @MyApplicationScope
    public Cache cache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000); //10MB Cahe
    }

    @Provides
    @MyApplicationScope
    public File cacheFile(Context context)
    {
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    @MyApplicationScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }
}
