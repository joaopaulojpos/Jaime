package com.jaime.jaime.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jaime.jaime.R;
import com.jaime.jaime.adapter.EstabelecimentoAdapter;
import com.jaime.jaime.domain.Estabelecimento;
import com.jaime.jaime.util.AlimentarCampos;

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

        estabelecimentos = new ArrayList<Estabelecimento>();
        estabelecimentos = alimentarEstabelecimentos(categoria);
        adapter = new EstabelecimentoAdapter(this, estabelecimentos);

        listView.setAdapter(adapter);

        //Se tiver vazio mostra um ícone do Android
        listView.setEmptyView(findViewById(android.R.id.empty));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                Estabelecimento estabelecimento = (Estabelecimento) adapterView.getItemAtPosition(position);
                if (estabelecimento != null) {

                    Intent intentProximaPagina = new Intent(SelecionarLocalActivity.this, EstabelecimentoInfoActivity.class);
                    intentProximaPagina.putExtra("Estabelecimento", estabelecimento);
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
        categoria = extrasPaginaAnterior.getString("Categoria");

    }

    /**
     * Settando na mão por enquanto
     *
     * @return Uma Lista com todos estabelecimentos
     */
    private List<Estabelecimento> alimentarEstabelecimentos(String categoria) {
        AlimentarCampos alimentarCampos = new AlimentarCampos();

        List<Estabelecimento> lisst = new ArrayList<Estabelecimento>();

        lisst.addAll(alimentarCampos.pegarListaEstabelecimentosAlimentada(categoria));

        return lisst;
    }


}
