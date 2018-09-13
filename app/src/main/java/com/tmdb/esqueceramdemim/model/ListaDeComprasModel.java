package com.tmdb.esqueceramdemim.model;

import android.support.annotation.NonNull;

import java.util.Date;

public class ListaDeComprasModel {

    @NonNull
    private String mTitulo;

    @NonNull
    private Date mData;

    @NonNull
    private String mItem;

    @NonNull
    private double mQuantidade;

    @NonNull
    private String mUnidade;

    private double mPreco;

    @NonNull
    public String getmTitulo() {
        return mTitulo;
    }

    public void setmTitulo(@NonNull String mTitulo) {
        this.mTitulo = mTitulo;
    }

    @NonNull
    public Date getmData() {
        return mData;
    }

    public void setmData(@NonNull Date mData) {
        this.mData = mData;
    }

    @NonNull
    public String getmItem() {
        return mItem;
    }

    public void setmItem(@NonNull String mItem) {
        this.mItem = mItem;
    }

    @NonNull
    public double getmQuantidade() {
        return mQuantidade;
    }

    public void setmQuantidade(@NonNull double mQuantidade) {
        this.mQuantidade = mQuantidade;
    }

    @NonNull
    public String getmUnidade() {
        return mUnidade;
    }

    public void setmUnidade(@NonNull String mUnidade) {
        this.mUnidade = mUnidade;
    }

    public double getmPreco() {
        return mPreco;
    }

    public void setmPreco(double mPreco) {
        this.mPreco = mPreco;
    }
}
