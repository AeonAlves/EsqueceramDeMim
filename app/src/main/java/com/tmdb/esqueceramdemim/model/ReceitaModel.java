package com.tmdb.esqueceramdemim.model;

import android.support.annotation.NonNull;

public class ReceitaModel {
    @NonNull
    private int mId;
    @NonNull
    private String mTitulo;
    @NonNull
    private String mConteudo;

    private String mImagem;

    private String mUrlVideo;

    @NonNull
    public int getmId() {
        return mId;
    }

    public void setmId(@NonNull int mId) {
        this.mId = mId;
    }

    public String getmImagem() {
        return mImagem;
    }

    public void setmImagem(String mImagem) {
        this.mImagem = mImagem;
    }

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
