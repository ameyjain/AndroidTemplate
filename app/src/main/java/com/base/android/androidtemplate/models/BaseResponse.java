package com.base.android.androidtemplate.models;

public class BaseResponse
{
    private String status;
    public String message;
    public int code;
    public String name;

    public boolean isSuccess()
    {
        // Some responses don't include the status of the request even though they succeeded, so we assume that those are successful
        return status == null || !status.equals("error");
    }

}
