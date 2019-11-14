package com.primeiro.financas2.modeloObj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.ArrayAdapter;

import com.primeiro.financas2.Classes_importante.BancoDados;

import java.util.ArrayList;
import java.util.List;

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
    //parametro classe conta
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
    //parametro codigo
    public Integer Excluir(int codigo){
        //EXCLUINDO  REGISTRO E RETORNANDO O NÚMERO DE LINHAS AFETADAS
        return bancoDados.GetConexaoDataBase().delete("tb_conta","id_Conta = ?",
                new String[]{Integer.toString(codigo)});
    }

    //CONSULTA UMA CONTA CADASTRADA PELO CÓDIGO
    //parametro codigo
    public Conta Getconta (int codigo){
        Cursor cursor = bancoDados.GetConexaoDataBase().rawQuery("SELECT * FROM tb_conta  WHERE id_Conta= "
        + codigo, null);

        cursor.moveToFirst();

        //CRIANDO UMA NOVA conta
        Conta conta = new Conta();

        //ADICIONANDO OS DADOS DA conta
        conta.setCodigo(cursor.getInt(cursor.getColumnIndex("id_conta")));
        conta.setConta(cursor.getString(cursor.getColumnIndex("conta")));
        conta.setValor(cursor.getInt(cursor.getColumnIndex("valor")));
        conta.setRegistroAtivo((byte)cursor.getShort(cursor.getColumnIndex("registroAtivo")));

        //RETORNANDO A PESSOA
        return conta;
    }

    //CONSULTA TODAS AS CONTAS CADASTRADAS NA BASE
    //COM RETORNO
    public List<Conta> Selecionar(){
        List<Conta> conta = new ArrayList<Conta>();

        //MONTA A QUERY A SER EXECUTADA
        StringBuilder stringQuery = new StringBuilder();

        stringQuery.append( "SELECT id_conta,");
        stringQuery.append(" Conta,");
        stringQuery.append(" valor,");
        stringQuery.append(" registroAtivo");
        stringQuery.append(" FROM  tb_pessoa ");
        stringQuery.append(" ORDER BY conta");

        //CONSULTANDO OS REGISTROS CADASTRADOS
        Cursor cursor = bancoDados.GetConexaoDataBase().rawQuery(stringQuery.toString(), null);

        /*POSICIONA O CURSOR NO PRIMEIRO REGISTRO*/
        cursor.moveToFirst();

        Conta contas;

        //REALIZA A LEITURA DOS REGISTROS ENQUANTO NÃO FOR O FIM DO CURSOR
        while (!cursor.isAfterLast()){
            /* CRIANDO UMA NOVA CONTA */
            contas = new Conta();

            //ADICIONANDO OS DADOS DA CONTAS

            contas.setCodigo(cursor.getInt(cursor.getColumnIndex("id_conta")));
            contas.setConta(cursor.getString(cursor.getColumnIndex("conta")));
            contas.setValor(cursor.getInt(cursor.getColumnIndex("valor")));
            contas.setRegistroAtivo((byte)cursor.getShort(cursor.getColumnIndex("registroAtivo")));

            //ADICIONANDO UMA PESSOA NA LISTA
            conta.add(contas);

            //VAI PARA O PRÓXIMO REGISTRO
            cursor.moveToNext();
        }

        //RETORNANDO A LISTA DE PESSOAS
        return conta;
    }

    /*como usar where em querys.
    Exemplo
    Select campo
    From Tabela
    Where estado ='SP '
    */
}
