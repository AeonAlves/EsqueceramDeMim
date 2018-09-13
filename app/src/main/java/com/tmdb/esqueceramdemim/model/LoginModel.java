package com.tmdb.esqueceramdemim.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by diego on 12/09/2018.
 */

public class LoginModel {

    private String mEmail;
    @NonNull
    private String mSenha;

    //Getters and Setters
    @NonNull
    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(@NonNull String mEmail) {
        this.mEmail = mEmail;
    }

    @NonNull
    public String getmSenha() {
        return mSenha;
    }

    public void setmSenha(@NonNull String mSenha) {
        this.mSenha = mSenha;
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getmEmail()) && Patterns.EMAIL_ADDRESS.matcher(getmEmail()).matches() && getmSenha().length() > 5;
    }
}
