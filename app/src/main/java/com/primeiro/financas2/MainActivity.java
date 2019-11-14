package com.primeiro.financas2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

        //CARREGA EVENTO PARA A LISTA
        this.Listar();

    }
    //VINCULA O COMPONENTE DA NOSSA TELA AO OBJETO DA NOSSA ATIVIDADE
    protected void Componentes(){

        //VINCULANDO A LISTA DA TELA AO LISTVIEW QUE DECLARAMOS
        ListaOpcao = (ListView) this.findViewById(R.id.ListaOpcao);
    }

    //CRIA A OPÇÕES DA NOSSA LISTA E ADICIONA AO LISTVIEW DA NOSSA TELA.
    protected  void OpcoesLista(){

        String[] itens = new String[2];

        itens[0] = "CADASTRAR";
        itens[1] = "CONSULTAR";

        ArrayAdapter<String> arrayItens = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itens);
        ListaOpcao.setAdapter(arrayItens);

    }
    //CRIA EVENTO PARA A LISTA
    protected void Listar(){
        ListaOpcao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcaoMenu =((TextView)view).getText().toString();

                RedirecionaTela(opcaoMenu);
            }
        });
    }

    //REDIRECIONA PARA A TELA SELECIONADA NO MENU
    protected void RedirecionaTela(String opcaoMenu){
        Intent redireciona;
        if (opcaoMenu.equals("CADASTRAR")) {
            redireciona = new Intent(this, CadastroConta.class);
            startActivity(redireciona);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Opção inválida!", Toast.LENGTH_SHORT).show();
        }
    }
}
