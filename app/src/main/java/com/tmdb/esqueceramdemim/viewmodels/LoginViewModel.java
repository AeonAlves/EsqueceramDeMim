package com.tmdb.esqueceramdemim.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.tmdb.esqueceramdemim.BR;
import com.tmdb.esqueceramdemim.model.LoginModel;

/**
 * Created by diego on 12/09/2018.
 */

public class LoginViewModel extends BaseObservable {

    private LoginModel _login;

    private String successMessage = "Logado com sucesso";
    private String errorMessage = "E-mail ou Senha inválidos";

    @Bindable
    public String toastMessage = null;

    public String getToastMessage(){
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public LoginViewModel(LoginModel login) {
        _login = login;
    }

    public void afterEmailTextChanged(CharSequence s) {
        _login.setmEmail(s.toString());
    }

    public void afterPasswordTextChanged(CharSequence s) {
        _login.setmSenha(s.toString());
    }

    public void onLoginClicked() {
        if (_login.isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }
}
