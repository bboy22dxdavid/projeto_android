package com.primeiro.financas2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.primeiro.financas2.Classes_importante.Alertas;
import com.primeiro.financas2.modeloObj.CRUD_Conta;
import com.primeiro.financas2.modeloObj.Conta;

/*
 * @author David nilo
 * on 13/11/2019.
 */
public class CadastroConta extends AppCompatActivity {
    /*COMPONENTES DA TELA*/
    EditText editTextConta, editTextValor;
    CheckBox checkBoxRegistroAtivo;
    Button buttonVoltar, buttonSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);
        //VINCULA OS COMPONENTES DA TELA COM OS DA ATIVIDADE
        this.ComponentesTela();

        //CRIA OS EVENTOS DOS COMPONENTES
        this.Eventos();
    }
    //VINCULA OS COMPONENTES DA TELA COM OS DA ATIVIDADE
    protected  void ComponentesTela(){
        //testeView
        editTextConta =(EditText) this.findViewById(R.id.editTextConta);
        editTextValor =(EditText) this.findViewById(R.id.editTextValor);
        //checkbox
        checkBoxRegistroAtivo =(CheckBox) this.findViewById(R.id.checkBoxRegistroAtivo);
        //button
        buttonSalvar =(Button) this.findViewById(R.id.buttonSalvar);
        buttonVoltar =(Button) this.findViewById(R.id.buttonVoltar);

    }

    //CRIA OS EVENTOS DOS COMPONENTES
    protected  void Eventos(){
        //CRIANDO EVENTO NO BOTÃO SALVAR
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Salvar_onClick();
            }
        });

        //CRIANDO EVENTO NO BOTÃO VOLTAR
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicio = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(inicio);
                finish();
            }
        });
    }
    //VALIDA OS CAMPOS E SALVA AS INFORMAÇÕES NO BANCO DE DADOS
    protected  void Salvar_onClick(){
        if (editTextConta.getText().toString().trim().equals("")){
            Alertas.alerta(this, this.getString(R.string.conta_obrigatorio));
            editTextConta.requestFocus();
        } else if (editTextValor.getText().toString().trim().equals("")){
            Alertas.alerta(this, this.getString(R.string.valor_obrigatorio));
            editTextValor.requestFocus();
        }else {
            Conta conta = new Conta();
            /*SETA O REGISTRO COMO INATIVO*/
            conta.setRegistroAtivo((byte)0);
            /*SE TIVER SELECIONADO SETA COMO ATIVO*/
            if (checkBoxRegistroAtivo.isChecked()){
                conta.setRegistroAtivo((byte)1);

                /*SALVANDO UM NOVO REGISTRO*/
                new CRUD_Conta(this).Salvar(conta);
                /*MENSAGEM DE SUCESSO!*/
                Alertas.alerta(this,this.getString(R.string.registro_salvo_sucesso));

                Limpar();
            }
        }
    }
    //LIMPA OS CAMPOS APÓS SALVAR AS INFORMAÇÕES
    protected void Limpar(){
        editTextConta.setText(null);
        editTextValor.setText(null);

        checkBoxRegistroAtivo.setChecked(false);
    }
}
