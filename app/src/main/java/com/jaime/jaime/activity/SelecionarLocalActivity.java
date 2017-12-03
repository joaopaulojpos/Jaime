package com.jaime.jaime.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jaime.jaime.R;
import com.jaime.jaime.adapter.EstabelecimentoAdapter;
import com.jaime.jaime.dao.EstabelecimentoDAO;
import com.jaime.jaime.domain.Estabelecimento;
import com.jaime.jaime.util.DarCargaNoBanco;

import java.util.ArrayList;
import java.util.List;

public class SelecionarLocalActivity extends AppCompatActivity {

    //ATRIBUTOS

    private Bundle extrasPaginaAnterior;
    private Bundle extrasProximaPagina;
    List<Estabelecimento> estabelecimentos;
    EstabelecimentoAdapter adapter;
    ListView listView;
    private String categoria;

    //METODOS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_local);

        pegarReferencias();
        pegarExtras();

        estabelecimentos = new ArrayList<>();
        DarCargaNoBanco darCargaNoBanco = new DarCargaNoBanco();

        //Pega do banco os Estabelecimentos da categoria escolhida
        estabelecimentos = listarEstabelecimentos(categoria);

        //se a lista estiver vazia quer dizer que o banco tá vazio, então...
        if (estabelecimentos.isEmpty()) {
            //Damos uma carga no banco por ex: Se o usuário quer listar os shoppings, esse método
            //darCarga vai inserir no banco todos os shoppings
            darCargaNoBanco.darCarga(SelecionarLocalActivity.this, categoria);
            //agora quando for pegar do banco não vai mais vir vazia
            estabelecimentos = listarEstabelecimentos(categoria);
        }
        adapter = new EstabelecimentoAdapter(this, estabelecimentos);

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged(); //acho q não precisa disso aqui

        //Se tiver vazio mostra um ícone do Android(não tá funcionando)
        listView.setEmptyView(findViewById(android.R.id.empty));

        //Se o usuário clicar em algum item da lista...
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //pega o estabelecimento selecionado
                Estabelecimento estabelecimento = (Estabelecimento) adapterView.getItemAtPosition(position);

                //se não tiver nulo..
                if (estabelecimento != null) {
                    //prepara a intent pra próxima pagina
                    Intent intentProximaPagina = new Intent(SelecionarLocalActivity.this, EstabelecimentoInfoActivity.class);
                    //coloca no Bundle da intent da próxima página o estabelecimento selecionado
                    // pra quando tiver lá saber qual foi o stabelecimento que o usuário escolheu
                    intentProximaPagina.putExtra("Estabelecimento", estabelecimento);
                    //cria a próxima página
                    startActivity(intentProximaPagina);
                }
            }
        });

    }

    private void pegarReferencias() {
        listView = (ListView) findViewById(R.id.lista);
    }


    private void pegarExtras() {
        extrasPaginaAnterior = getIntent().getExtras();
        //pega a categoria que foi escolhida na página anterior
        categoria = extrasPaginaAnterior.getString("Categoria");
    }

    /**
     * Lista todos os estabelecimentos(falta botar o filtro)
     *
     * @return
     */
    public List<Estabelecimento> listarEstabelecimentos(String categoria) {
        List<Estabelecimento> lista = new ArrayList<>();
        EstabelecimentoDAO dao = new EstabelecimentoDAO(SelecionarLocalActivity.this);
        lista = (List<Estabelecimento>) dao.listarEstabelecimentos(categoria);
        return lista;
    }
}
