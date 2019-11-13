package com.primeiro.financas2.modeloObj;

import android.content.ContentValues;
import android.content.Context;

import com.primeiro.financas2.Classes_importante.BancoDados;

/*
 * @author David nilo
 * on 12/11/2019.
 */
public class CRUD_Conta {
    BancoDados bancoDados;
    // construtor para context
    public CRUD_Conta(Context context){

        bancoDados =  new BancoDados(context);

    }

    public void Salvar(Conta conta){
        ContentValues contentValues =  new ContentValues();
        //MONTANDO OS PARAMETROS PARA SEREM SALVOS
        contentValues.put("conta",conta.getConta());
        contentValues.put("valor", conta.getValor());
        contentValues.put("registro", conta.getRegistroAtivo());
        /*EXECUTANDO INSERT DE UM NOVO REGISTRO*/
        bancoDados.GetConexaoDataBase().insert("tb_conta", null,contentValues);
    }

    //ATUALIZA UM REGISTRO JÁ EXISTENTE NA BASE

    public  void  Atualizer(Conta conta){
        ContentValues contentValues =  new ContentValues();
        /*MONTA OS PARAMENTROS PARA REALIZAR UPDATE NOS CAMPOS*/
        contentValues.put("conta",conta.getConta());
        contentValues.put("valor", conta.getValor());
        contentValues.put("registro", conta.getRegistroAtivo());
        /*REALIZANDO UPDATE PELA CHAVE DA TABELA*/
        bancoDados.GetConexaoDataBase().update("tb_conta", contentValues, "id_Conta = ?",
                new String[]{Integer.toString(conta.getCodigo())});
    }

    //EXCLUI UM REGISTRO PELO CÓDIGO
    
}
