package com.base.android.androidtemplate.utils;

/**
 * Created by amey on 4/15/18
 */
public class StringUtils
{
    public static boolean isEmpty(String str)
    {
        return str == null || str.isEmpty();
    }

    public static boolean isValidEmail(String email)
    {
        return !isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}