package com.base.android.androidtemplate.models;

import android.content.Context;

import com.base.android.androidtemplate.components.MyApplicationScope;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Amey on 3/11/18.
 */

@Module(includes = ContextModule.class)
public class PicassoModule
{

    @Provides
    @MyApplicationScope
    public Picasso picasso(Context context, OkHttp3Downloader okHttp3Downloader)
    {
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    @MyApplicationScope
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient)
    {
        return new OkHttp3Downloader(okHttpClient);
    }

}
