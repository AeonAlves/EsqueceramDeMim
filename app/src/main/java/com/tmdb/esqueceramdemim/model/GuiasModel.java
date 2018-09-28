package com.tmdb.esqueceramdemim.model;

import android.support.annotation.NonNull;

public class GuiasModel {

    @NonNull
    private int mId;
    @NonNull
    private String mTitulo;
    @NonNull
    private String mConteudo;

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

    public String getmUrlVideo() {
        return mUrlVideo;
    }

    public void setmUrlVideo(String mUrlVideo) {
        this.mUrlVideo = mUrlVideo;
    }
}
