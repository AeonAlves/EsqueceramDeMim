package com.tmdb.esqueceramdemim.Async;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;

import org.json.JSONException;

public class CriarBD extends SQLiteOpenHelper {

    //Tabela Receitas
    private static final String NOME_BANCO = "usecred.db";
    private static final String TABELAEST = "estabelecimentos";
    private static final String TABELACAT = "categorias";

    //TABELA Guias
    private static final String EST_ID = "_id ";
    private static final String CATEGORIA = "categoria";
    private static final String EST_NOME = "nome";
    private static final String EST_END = "endereco";
    private static final String BAIRRO = "bairro";
    private static final String CIDADE = "cidade";
    private static final String UF = "uf";
    private static final String EST_CEP = "cep";
    private static final String EST_TEL1 = "telefone_1";
    private static final String EST_TEL2 = "telefone_2";

    //TABELA Prestadores
    private static final String CAT_ID = "_id";
    private static final String CAT_DESC = "categoria";

    //TABELA Lista de compras

    //TABELA Estoque


    private static final int VERSAO = 1;

    public CriarBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
