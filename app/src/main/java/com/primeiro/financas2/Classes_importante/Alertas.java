package com.primeiro.financas2.Classes_importante;

import android.app.AlertDialog;
import android.content.Context;

import com.primeiro.financas2.R;

/*
 * @author David nilo
 * on 13/11/2019.
 */
public class Alertas {
    public static void alerta(Context context, String mensagem){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        //ADICIONANDO UM TITULO A NOSSA MENSAGEM DE ALERTA
        alertDialog.setTitle(R.string.app_name);
        //MENSAGEM A SER EXIBIDA
        alertDialog.setMessage(mensagem);

        //CRIA UM BOTÃO COM O TEXTO OK SEM AÇÃO
        alertDialog.setPositiveButton("OK", null);

        //MOSTRA A MENSAGEM NA TELA
        alertDialog.show();

    }
}
