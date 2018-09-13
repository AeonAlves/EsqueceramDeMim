package com.tmdb.esqueceramdemim.viewmodels;

import android.databinding.BaseObservable;

import com.tmdb.esqueceramdemim.model.ReceitaModel;

public class ReceitaViewModel extends BaseObservable {

    private ReceitaModel _receita;

    public ReceitaViewModel(ReceitaModel receita){
        _receita = receita;
    }
}
