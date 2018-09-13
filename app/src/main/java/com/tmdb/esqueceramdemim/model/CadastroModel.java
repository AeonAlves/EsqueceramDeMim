package com.tmdb.esqueceramdemim.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by diego on 12/09/2018.
 */

public class CadastroModel {

    @NonNull
    private String mNome;
    @NonNull
    private String mEmail;
    @NonNull
    private String mSenha;
    @NonNull
    private String mConfSenha;
    @NonNull
    private String mDDD;
    @NonNull
    private String mTelefone;
    @NonNull
    private String mCEP;
    @NonNull
    private String mEndereco;
    @NonNull
    private String mNumero;
    @NonNull
    private String mComplemento;
    @NonNull
    private String mBairro;
    @NonNull
    private String mCidade;
    @NonNull
    private String mEstado;

    //Getters and Setters
    @NonNull
    public String getmNome() {
        return mNome;
    }

    public void setmNome(@NonNull String mNome) {
        this.mNome = mNome;
    }

    @NonNull
    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(@NonNull String mEmail) {
        this.mEmail = mEmail;
    }

    @NonNull
    public String getmSenha() {
        return mSenha;
    }

    public void setmSenha(@NonNull String mSenha) {
        this.mSenha = mSenha;
    }

    @NonNull
    public String getmConfSenha() {
        return mConfSenha;
    }

    public void setmConfSenha(@NonNull String mConfSenha) {
        this.mConfSenha = mConfSenha;
    }

    @NonNull
    public String getmDDD() {
        return mDDD;
    }

    public void setmDDD(@NonNull String mDDD) {
        this.mDDD = mDDD;
    }

    @NonNull
    public String getmTelefone() {
        return mTelefone;
    }

    public void setmTelefone(@NonNull String mTelefone) {
        this.mTelefone = mTelefone;
    }

    @NonNull
    public String getmCEP() {
        return mCEP;
    }

    public void setmCEP(@NonNull String mCEP) {
        this.mCEP = mCEP;
    }

    @NonNull
    public String getmEndereco() {
        return mEndereco;
    }

    public void setmEndereco(@NonNull String mEndereco) {
        this.mEndereco = mEndereco;
    }

    @NonNull
    public String getmNumero() {
        return mNumero;
    }

    public void setmNumero(@NonNull String mNumero) {
        this.mNumero = mNumero;
    }

    @NonNull
    public String getmComplemento() {
        return mComplemento;
    }

    public void setmComplemento(@NonNull String mComplemento) {
        this.mComplemento = mComplemento;
    }

    @NonNull
    public String getmBairro() {
        return mBairro;
    }

    public void setmBairro(@NonNull String mBairro) {
        this.mBairro = mBairro;
    }

    @NonNull
    public String getmCidade() {
        return mCidade;
    }

    public void setmCidade(@NonNull String mCidade) {
        this.mCidade = mCidade;
    }

    @NonNull
    public String getmEstado() {
        return mEstado;
    }

    public void setmEstado(@NonNull String mEstado) {
        this.mEstado = mEstado;
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getmEmail()) && Patterns.EMAIL_ADDRESS.matcher(getmEmail()).matches() && getmSenha().length() > 5;
    }
}

