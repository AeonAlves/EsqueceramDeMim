package com.tmdb.esqueceramdemim.viewmodels;

import android.databinding.BaseObservable;

import com.tmdb.esqueceramdemim.model.EstoqueModel;

public class EstoqueViewModel extends BaseObservable {

    private EstoqueModel _estoque;

    public EstoqueViewModel(EstoqueModel estoque){
        _estoque = estoque;
    }
}
