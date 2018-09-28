package com.tmdb.esqueceramdemim.model;

import android.support.annotation.NonNull;

public class ServicosModel {

    @NonNull
    private int mId;

    @NonNull
    private String mPrestador;

    @NonNull
    private String mProduto;

    @NonNull
    private String mDescricao;

    @NonNull
    private String mTelefone;

    private String mImagem;

    private int mAvaliacao;

    @NonNull
    public int getmId() {
        return mId;
    }

    public void setmId(@NonNull int mId) {
        this.mId = mId;
    }

    @NonNull
    public String getmPrestador() {
        return mPrestador;
    }

    public void setmPrestador(@NonNull String mPrestador) {
        this.mPrestador = mPrestador;
    }

    @NonNull
    public String getmProduto() {
        return mProduto;
    }

    public void setmProduto(@NonNull String mProduto) {
        this.mProduto = mProduto;
    }

    @NonNull
    public String getmDescricao() {
        return mDescricao;
    }

    public void setmDescricao(@NonNull String mDescricao) {
        this.mDescricao = mDescricao;
    }

    @NonNull
    public String getmTelefone() {
        return mTelefone;
    }

    public void setmTelefone(@NonNull String mTelefone) {
        this.mTelefone = mTelefone;
    }

    public String getmImagem() {
        return mImagem;
    }

    public void setmImagem(String mImagem) {
        this.mImagem = mImagem;
    }

    public int getmAvaliacao() {
        return mAvaliacao;
    }

    public void setmAvaliacao(int mAvaliacao) {
        this.mAvaliacao = mAvaliacao;
    }
}
