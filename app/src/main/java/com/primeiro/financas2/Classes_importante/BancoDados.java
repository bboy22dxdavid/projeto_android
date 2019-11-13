package com.primeiro.financas2.Classes_importante;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
 * @author David nilo
 * on 12/11/2019.
 */
public class BancoDados extends SQLiteOpenHelper {
    //NOME DA BASE DE DADOS
    private static final String BaseDados   = "SISTEMA.db";
    //VERSÃO DO BANCO DE DADOS
    private static final int    VERSAO = 1;
    //CONSTRUTOR
    public BancoDados(Context context){

        super(context,BaseDados,null,VERSAO);
    }
    @Override
    /*NA INICIALIZAÇÃO DA CLASSE VAMOS CRIAR A TABELA QUE VAMOS USAR*/
    public void onCreate(SQLiteDatabase db) {
        StringBuilder CreateTable = new StringBuilder();
        //criando a tabela de contas
        CreateTable.append("CREATE TABLE tb_conta (");
        CreateTable.append("   id_Conta   INTEGER PRIMARY KEY AUTOINCREMENT,");
        CreateTable.append("   conta        TEXT    NOT NULL,");
        CreateTable.append("   valor        TEXT    NOT NULL,");
        CreateTable.append("   fl_ativo       INT     NOT NULL ) ");

        db.execSQL(CreateTable.toString());
         /*SE TROCAR A VERSÃO DO BANCO DE DADOS VOCÊ PODE EXECUTAR ALGUMA ROTINA
      COMO CRIAR COLUNAS, EXCLUIR ENTRE OUTRAS */
    }

    @Override
    // metodo que atualiza banco de dabos
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tb_conta");
        onCreate(db);
    }
    /*MÉTODO QUE VAMOS USAR NA CLASSE QUE VAI EXECUTAR AS ROTINAS NO
    BANCO DE DADOS*/
    public SQLiteDatabase GetConexaoDataBase(){
        return this.getWritableDatabase();
    }
}
