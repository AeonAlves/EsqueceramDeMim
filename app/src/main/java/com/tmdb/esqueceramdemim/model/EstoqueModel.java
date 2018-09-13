package com.tmdb.esqueceramdemim.model;

import android.support.annotation.NonNull;

import java.util.Date;

public class EstoqueModel {

    @NonNull
    private String mLocal;

    @NonNull
    private String mItem;

    @NonNull
    private Date mValidade;

    @NonNull
    public String getmLocal() {
        return mLocal;
    }

    public void setmLocal(@NonNull String mLocal) {
        this.mLocal = mLocal;
    }

    @NonNull
    public String getmItem() {
        return mItem;
    }

    public void setmItem(@NonNull String mItem) {
        this.mItem = mItem;
    }

    @NonNull
    public Date getmValidade() {
        return mValidade;
    }

    public void setmValidade(@NonNull Date mValidade) {
        this.mValidade = mValidade;
    }
}
