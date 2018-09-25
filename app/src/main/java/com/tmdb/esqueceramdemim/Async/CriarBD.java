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

    //Banco
    private static final String NOME_BANCO = "EsqueceramDeMim.db";
    private static final String TABELAREC = "Receitas";
    private static final String TABELAGUIAS = "Guias";
    private static final String TABELASERV = "Servicos";
    private static final String TABELALISTA = "ListaDeCompras";
    private static final String TABELAITENS = "ItensLista";

    //TABELA RECEITAS
    private static final String RID         = "Id";
    private static final String RTITULO     = "Titulo";
    private static final String RCONTEUDO   = "Conteudo";
    private static final String RDIF        = "Dificuldade";
    private static final String RIMAGEM     = "Imagem";
    private static final String RURL        = "Url";

    //TABELA GUIAS
    private static final String GID         = "Id";
    private static final String GTITULO     = "Titulo";
    private static final String GCONTEUDO   = "Conteudo";
    private static final String GURL        = "Url";

    //TABELA Prestadores de Servicos
    private static final String SID         = "Id";
    private static final String SNOME       = "NomePrestador";
    private static final String SSERVICO    = "ServicoPrestador";
    private static final String STELEFONE   = "Telefone";
    private static final String SDESCRICAO  = "Descricao";
    private static final String SIMAGEM     = "Imagem";
    private static final String SAVALIACAO  = "Avaliacao";

    //TABELA LISTA DE COMPRAS
    private static final String LID         = "Id";
    private static final String LTITULO     = "Titulo";
    private static final String LDATA       = "Data";
    private static final String LVALOR      = "Valor";

    //TABELA ITENS
    private static final String ILISTA      = "IdLista";
    private static final String IID         = "Id";
    private static final String IITEM       = "Item";
    private static final String IQUANT      = "Quantidade";
    private static final String IUNID       = "Unidade";
    private static final String IPRECO      = "Preco";

    private static final int VERSAO = 1;

    public CriarBD(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String pragma = "PRAGMA foreign_keys = on";
        sqLiteDatabase.execSQL(pragma);

        String criarReceitas = "CREATE TABLE " + TABELAREC + " ("
                + RID + "integer primary key autoincrement,"
                + RTITULO + "text,"
                + RCONTEUDO + "text,"
                + RDIF + "integer"
                + RIMAGEM + "blob,"
                + RURL + "text"
                + ")" ;
        sqLiteDatabase.execSQL(criarReceitas);

        String criarGuias = "CREATE TABLE " + TABELAGUIAS + " ("
                + GID + "integer primary key autoincrement,"
                + GTITULO + "text,"
                + GCONTEUDO + "text,"
                + GURL + "text"
                + ")" ;
        sqLiteDatabase.execSQL(criarGuias);

        String criarServicos = "CREATE TABLE " + TABELASERV + " ("
                + SID + "integer primary key autoincrement,"
                + SNOME + "text,"
                + SSERVICO + "text,"
                + SIMAGEM + "blob,"
                + STELEFONE + "text,"
                + SDESCRICAO + "text,"
                + SAVALIACAO + "text"
                + ")" ;
        sqLiteDatabase.execSQL(criarServicos);

        String criarLista = "CREATE TABLE " + TABELALISTA + " ("
                + LID + "integer primary key autoincrement,"
                + LTITULO + "text,"
                + LDATA + "date,"
                + LVALOR + "real"
                + ")" ;
        sqLiteDatabase.execSQL(criarLista);

        String criarItens = "CREATE TABLE " + TABELAITENS + " ("
                + IID + "integer primary key autoincrement,"
                + IITEM + "text,"
                + ILISTA + "integer,"
                + IPRECO + "blob,"
                + IQUANT + "text"
                + IUNID + "text,"
                + "FOREIGN KEY(IdLista) REFERENCES ListaDeCompras(Id)"
                + ")" ;
        sqLiteDatabase.execSQL(criarItens);

        String insRec = "INSERT INTO " + TABELAREC + "(Titulo, Conteudo, Dificuldade) "
                + "VALUES ('Arroz Soltinho', '<html>\n" +
                "<head>\n" +
                "<title></title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>ARROZ SOLTINHO</h2>\n" +
                "</br></br>\n" +
                "<div>\n" +
                "<h3>INGREDIENTES</H3>\n" +
                "</br></br>\n" +
                "<ul>\n" +
                "\t<li>Agua</li>\n" +
                "\t<li>Arroz</li>\n" +
                "\t<li>Alho</li>\n" +
                "\t<li>Cebola</li>\n" +
                "\t<li>Sal</li>\n" +
                "\t<li>Oleo</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "<div>\n" +
                "<h3>MODO DE PREPARO</h3>\n" +
                "<ol>\n" +
                "\t<li>Lave bem uma xícara (aprox. 150g) de arroz, deixe escorrer bem;</li>\n" +
                "\t<li>Em uma panela pequena coloque 2 colheres de sopa de oleo e doure o alho e a cebola picados;</li>\n" +
                "\t<li>Acrescente o arroz na panela e deixe fritar por alguns segundos;</li>\n" +
                "\t<li>Abaixe o fogo, acrescente a primeira xícara de água e deixe ferver (com a panela semi tampada), mexendo de vez em quando;.</li>\n" +
                "\t<li>Quando estiver quase secando abra a panela e acrescente a segunda xícara de água; </li>\n" +
                "\t<li>Assim que secar desligue o fogo.</li>\n" +
                "</ol>\n" +
                "</div>\n" +
                "<h3>RENDE: 4 PORÇÕES</h3>\n" +
                "</body>\n" +
                "</html>', 1)";
        sqLiteDatabase.execSQL(insRec);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELAREC);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELAGUIAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELASERV);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELALISTA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELAITENS);
        onCreate(sqLiteDatabase);
    }
}

/*CREATE TABLE IF NOT EXISTS `EsqueceramDeMim`.`Receitas` (
        `Id` INT NOT NULL AUTO_INCREMENT,
        `Titulo` VARCHAR(45) NOT NULL,
        `Conteudo` VARCHAR(3000) NOT NULL,
        `Imagem` BLOB NOT NULL,
        `Url` VARCHAR(20) NULL,
        PRIMARY KEY (`Id`),
        UNIQUE INDEX `Titulo_UNIQUE` (`Titulo` ASC) VISIBLE)
        ENGINE = InnoDB;*/

        /*CREATE TABLE IF NOT EXISTS `EsqueceramDeMim`.`Guias` (
        `Id` INT NOT NULL AUTO_INCREMENT,
        `Titulo` VARCHAR(45) NOT NULL,
        `Conteudo` VARCHAR(3000) NOT NULL,
        `Url` VARCHAR(20) NULL,
        PRIMARY KEY (`Id`),
        UNIQUE INDEX `Titulo_UNIQUE` (`Titulo` ASC) VISIBLE)
        ENGINE = InnoDB;*/

        /*CREATE TABLE IF NOT EXISTS `EsqueceramDeMim`.`Servicos` (
        `Id` INT NOT NULL AUTO_INCREMENT,
        `NomePrestador` VARCHAR(60) NOT NULL,
        `ServicoPrestador` VARCHAR(45) NOT NULL,
        `Telefone` VARCHAR(15) NOT NULL,
        `Descricao` VARCHAR(45) NULL,
        `Imagem` BLOB NULL,
        `Avaliacao` FLOAT NULL,
        PRIMARY KEY (`Id`))
        ENGINE = InnoDB;*/

    /*CREATE TABLE IF NOT EXISTS `EsqueceramDeMim`.`ListaDeCompras` (
        `Id` INT NOT NULL AUTO_INCREMENT,
        `Titulo` VARCHAR(45) NOT NULL,
        `DataLista` DATE NOT NULL,
        `ValorTotal` FLOAT NULL,
        PRIMARY KEY (`Id`))
        ENGINE = InnoDB;*/

        /*CREATE TABLE IF NOT EXISTS `EsqueceramDeMim`.`ItensLista` (
        `ListaDeCompras_Id` INT NOT NULL,
        `IdItem` INT NOT NULL,
        `Item` VARCHAR(30) NOT NULL,
        `Quantidade` FLOAT NULL,
        `Unidade` VARCHAR(5) NULL,
        `Preço` FLOAT NULL,
        PRIMARY KEY (`IdItem`),
        INDEX `fk_ItensLista_ListaDeCompras_idx` (`ListaDeCompras_Id` ASC) VISIBLE,
        CONSTRAINT `fk_ItensLista_ListaDeCompras`
        FOREIGN KEY (`ListaDeCompras_Id`)
        REFERENCES `EsqueceramDeMim`.`ListaDeCompras` (`Id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION)
        ENGINE = InnoDB;*/

