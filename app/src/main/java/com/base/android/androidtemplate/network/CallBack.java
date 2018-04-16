package com.base.android.androidtemplate.network;

import com.base.android.androidtemplate.models.BaseResponse;

public interface CallBack <Result>
{
    void onSuccess(Result result);
    void onError(BaseResponse error);
}
