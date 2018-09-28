package com.tmdb.esqueceramdemim.model;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

public class ReceitaModel {
    @NonNull
    private int mId;
    @NonNull
    private String mTitulo;
    @NonNull
    private String mConteudo;

    @NonNull
    private String mDificuldade;

    private int mImagem;

    private String mUrlVideo;

    @NonNull
    public int getmId() {
        return mId;
    }

    public void setmId(@NonNull int mId) {
        this.mId = mId;
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

    @NonNull
    public String getmDificuldade() {
        return mDificuldade;
    }

    public void setmDificuldade(@NonNull String mDificuldade) {
        this.mDificuldade = mDificuldade;
    }

    public int getmImagem() {
        return mImagem;
    }

    public void setmImagem(int mImagem) {
        this.mImagem = mImagem;
    }

    public String getmUrlVideo() {
        return mUrlVideo;
    }

    public void setmUrlVideo(String mUrlVideo) {
        this.mUrlVideo = mUrlVideo;
    }
}
