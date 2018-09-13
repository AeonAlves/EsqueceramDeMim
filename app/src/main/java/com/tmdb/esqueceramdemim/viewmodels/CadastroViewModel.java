package com.tmdb.esqueceramdemim.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.tmdb.esqueceramdemim.BR;
import com.tmdb.esqueceramdemim.model.CadastroModel;

/**
 * Created by diego on 12/09/2018.
 */

public class CadastroViewModel extends BaseObservable {

    private CadastroModel _cadastro;

    public String requiredMessage = " obrigatório";


    @Bindable
    public String toastMessage;

    public String getToastMessage(){
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public CadastroViewModel(CadastroModel cadastro){
        _cadastro = cadastro;
    }

}
