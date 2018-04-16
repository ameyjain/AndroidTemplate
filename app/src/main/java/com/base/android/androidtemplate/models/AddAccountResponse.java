package com.base.android.androidtemplate.models;

import com.base.android.androidtemplate.Constants.AccountConstants;

/**
 *
 * A model to transfer account data after adding an Android account
 * Created by amey on 4/15/18
 */

public class AddAccountResponse extends BaseResponse
{
    public String accountName;
    public String accountType;
    public String authToken;

    public AddAccountResponse(String accountName, String authToken)
    {
        this.accountName = accountName;
        this.accountType = AccountConstants.ACCOUNT_TYPE;
        this.authToken = authToken;
    }
}