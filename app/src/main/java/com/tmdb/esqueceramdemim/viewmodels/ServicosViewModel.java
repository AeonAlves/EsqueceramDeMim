package com.tmdb.esqueceramdemim.viewmodels;

import android.databinding.BaseObservable;

import com.tmdb.esqueceramdemim.model.ServicosModel;

public class ServicosViewModel extends BaseObservable {

    private ServicosModel _servicos;

    public ServicosViewModel (ServicosModel servicos){
        _servicos = servicos;
    }
}
