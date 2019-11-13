package com.primeiro.financas2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/*
 * @author David nilo
 * on 12/11/2019.
 */
public class MainActivity extends AppCompatActivity {

    //DECLARANDO UM OBJETO LISTVIEW
    ListView ListaOpcao;

    @Override
    //MÉTODO onCreate EXECUTADO NA INICIALIZAÇÃO DA ACTIVITY
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DETERMINA O CONTEÚDO DA NOSSA ACTIVITY
        setContentView(R.layout.activity_main);
        /*CARREGA O MÉTODO DE CRIAÇÃO DOS COMPONENTES*/
        this.Componentes();

        /*CARREGA AS OPÇÕES DA LISTA*/
        this.OpcoesLista();

    }
    //VINCULA O COMPONENTE DA NOSSA TELA AO OBJETO DA NOSSA ATIVIDADE
    protected void Componentes(){

        //VINCULANDO A LISTA DA TELA AO LISTVIEW QUE DECLARAMOS
        ListaOpcao = (ListView) this.findViewById(R.id.ListaOpcao);
    }

    //CRIA A OPÇÕES DA NOSSA LISTA E ADICIONA AO LISTVIEW DA NOSSA TELA.
    protected  void OpcoesLista(){

        String[] itens = new String[2];

        itens[0] = "Cadastrar";
        itens[1] = "Consultar";

        ArrayAdapter<String> arrayItens = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itens);
        ListaOpcao.setAdapter(arrayItens);

    }
}
