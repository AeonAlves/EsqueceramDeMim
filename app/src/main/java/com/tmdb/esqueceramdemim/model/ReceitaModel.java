package com.tmdb.esqueceramdemim.model;

import android.support.annotation.NonNull;

public class ReceitaModel {
    @NonNull
    private String mTitulo;
    @NonNull
    private String mConteudo;

    private String mImagem;

    private String mUrlVideo;

    @NonNull
    public String getmTitulo() {
        return mTitulo;
    }

    public void setmTitulo(@NonNull String mTitulo) {
        this.mTitulo = mTitulo;
    }

    @NonNull
    public String getmConteudo() {
        return mConteudo;
    }

    public void setmConteudo(@NonNull String mConteudo) {
        this.mConteudo = mConteudo;
    }

    public String getmUrlVideo() {
        return mUrlVideo;
    }

    public void setmUrlVideo(String mUrlVideo) {
        this.mUrlVideo = mUrlVideo;
    }
}
