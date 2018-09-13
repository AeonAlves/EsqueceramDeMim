package com.tmdb.esqueceramdemim.viewmodels;

import android.databinding.BaseObservable;

import com.tmdb.esqueceramdemim.model.ListaDeComprasModel;

public class ListaDeComprasViewModel extends BaseObservable {

    private ListaDeComprasModel _listadecompras;

    public ListaDeComprasViewModel(ListaDeComprasModel listadecompras){
        _listadecompras = listadecompras;
    }
}
