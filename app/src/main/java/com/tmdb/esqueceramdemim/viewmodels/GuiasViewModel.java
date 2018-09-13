package com.tmdb.esqueceramdemim.viewmodels;

import android.databinding.BaseObservable;

import com.tmdb.esqueceramdemim.model.GuiasModel;

public class GuiasViewModel extends BaseObservable{

    private GuiasModel _guias;

    public GuiasViewModel(GuiasModel guias){
        _guias = guias;
    }
}
