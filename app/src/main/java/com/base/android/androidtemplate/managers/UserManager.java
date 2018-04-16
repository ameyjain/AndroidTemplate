package com.base.android.androidtemplate.managers;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import com.base.android.androidtemplate.Constants.AccountConstants;
import com.base.android.androidtemplate.models.AddAccountResponse;
import com.base.android.androidtemplate.models.BaseResponse;
import com.base.android.androidtemplate.models.User;
import com.base.android.androidtemplate.network.CallBack;
import com.base.android.androidtemplate.utils.LogUtils;
import com.base.android.androidtemplate.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import javax.inject.Inject;

import retrofit2.Callback;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.BehaviorSubject;

public class UserManager implements OnAccountsUpdateListener {

    @Inject
    Context context;
    @Inject
    Gson gson;

    private static final String TAG = "UserManager";
    private static final String DEFAULT_NAME = "AppPartner";

    private final AccountManager accountManager;
    private BehaviorSubject<Boolean> loggedIn;
    private User user;

    public UserManager()
    {
        this.accountManager = AccountManager.get(context);
        this.accountManager.addOnAccountsUpdatedListener(this, null, true);
        this.loggedIn = BehaviorSubject.create();

        loadUser();
    }

    //==============================================================================================
    // Class Instance Methods
    //==============================================================================================

    public boolean hasUser()
    {
        return user != null;
    }

    public User getUser()
    {
        return user;
    }

    private void setUser(User user)
    {
        this.user = user;
    }

    private void cacheUser(Account account, User user)
    {
        String userJson = gson.toJson(user);
        accountManager.setUserData(account, AccountConstants.KEY_USER_DATA, userJson);
    }

    public Observable<Boolean> getLoggedInObservable()
    {
        return loggedIn.observeOn(AndroidSchedulers.mainThread());
    }

    //TODO After fetching the user account call this
    private void updateUser(CallBack<AddAccountResponse> callBack)
    {
        Account account = addOrFindAccount(user.getFullName(),
                user.getToken());
        accountManager.setAuthToken(account,
                AccountConstants.AUTH_TOKEN_TYPE,
                user.getToken());

        setUser(user);
        cacheUser(account, user);

        AddAccountResponse addAccountResponse =
                new AddAccountResponse(user.getUserId(),
                        "TOKEN");
        callBack.onSuccess(addAccountResponse);

    }

    private Account addOrFindAccount(String name, String refreshToken)
    {
        if (StringUtils.isEmpty(name))
        {
            name = DEFAULT_NAME;
        }

        Account[] accounts = accountManager.getAccountsByType(AccountConstants.ACCOUNT_TYPE);
        Account account = accounts.length != 0 ? accounts[0] :
                new Account(name, AccountConstants.ACCOUNT_TYPE);

        Bundle bundle = new Bundle();
        bundle.putString(AccountConstants.KEY_REFRESH_TOKEN, refreshToken);

        if (accounts.length == 0)
        {
            accountManager.addAccountExplicitly(account, null, bundle);
        }
        else
        {
            accountManager.setUserData(account, AccountConstants.KEY_REFRESH_TOKEN, refreshToken);
        }

        return account;
    }

    private void loadUser()
    {
        Account[] accounts = accountManager.getAccountsByType(AccountConstants.ACCOUNT_TYPE);

        if (accounts.length > 0)
        {
            Account account = accounts[0];
            String userJson = accountManager.getUserData(account, AccountConstants.KEY_USER_DATA);
            if (!StringUtils.isEmpty(userJson))
            {
                try
                {
                    setUser(new Gson().fromJson(userJson, User.class));
                }
                catch (IllegalStateException | JsonSyntaxException e)
                {
                    LogUtils.e(TAG, e.getLocalizedMessage());
                }
            }
        }
    }


    //==============================================================================================
    // Network calls
    //==============================================================================================

    public void login(final String email,
                      String password,
                      final Callback<BaseResponse> callback)
    {

    }

    public void createAccount(final String email,
                              String password,
                              String firstName,
                              String lastName,
                              final CallBack<BaseResponse> callback)
    {

    }

    public void logout()
    {
        Account[] accounts = accountManager.getAccountsByType(AccountConstants.ACCOUNT_TYPE);

        if (accounts.length > 0)
        {
            Account account = accounts[0];
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1)
            {
                accountManager.removeAccountExplicitly(account);
            }
            else
            {
                accountManager.removeAccount(account, null, null);
            }
        }
    }

    //==============================================================================================
    // OnAccountsUpdateListener
    //==============================================================================================

    @Override
    public void onAccountsUpdated(Account[] accounts)
    {
        for (Account account : accounts)
        {
            if (AccountConstants.ACCOUNT_TYPE.equals(account.type))
            {
                return;
            }
        }

        user = null;
        loggedIn.onNext(false);
    }
}
