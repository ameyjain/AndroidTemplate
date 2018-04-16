package com.base.android.androidtemplate.models;

/**
 * Created by amey on 4/15/18
 */
public class User extends BaseResponse
{
    private String fullName;
    private String userId;
    private String token;

    public String getFullName() {
        return fullName;
    }

    public String getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }
}
