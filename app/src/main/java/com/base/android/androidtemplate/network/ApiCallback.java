package com.base.android.androidtemplate.network;

import com.base.android.androidtemplate.models.BaseResponse;
import com.base.android.androidtemplate.utils.LogUtils;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCallback<T extends BaseResponse> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.isSuccessful() && response.errorBody() == null)
        {
            assert response.body() != null;
            if (response.body().isSuccess())
            {
                onSuccess(response.body());
            }
            else {
                onApiError(response.body(), response.body().message, true);
            }
        }
        else if (response.errorBody() != null)
        {
            try
            {
                String error = response.errorBody().string();
                onApiError(null, error, false);
            }
            catch (IOException e)
            {
                LogUtils.d(getClass().getName(), "Response error body parse exception.", e);
                onApiError(null, e.getMessage(), false);
            }
        }


    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }

    /**
     * Called when the response is a success and the API successfully returned a status "success" when the status field is present
     *
     * @param t the body of the response
     */
    public void onSuccess(T t)
    {
    }

    /**
     * Called when the response is a failure,
     *
     * @param t the body of the response is there in case the response is a 200 status code but the status field of the response is "error"
     * @param errorMessage error messages concatened by a new line if there are several
     * @param isApiError flag to know whether we have a 200 status code or not
     */
    public void onApiError(T t, String errorMessage, boolean isApiError)
    {
        onApiErrorOrFailure(t, errorMessage, isApiError);
        onApiErrorOrFailure(errorMessage, isApiError);
    }

    public void onApiErrorOrFailure(T t, String errorMessages, boolean isApiError)
    {
    }

    public void onApiErrorOrFailure(String errorMessage, boolean isApiError)
    {
    }

}
