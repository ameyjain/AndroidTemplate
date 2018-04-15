package com.base.android.androidtemplate.network;

public interface CallBack <Result,Error>
{
    void onSuccess(Result result);
    void onError(Error error);
}
