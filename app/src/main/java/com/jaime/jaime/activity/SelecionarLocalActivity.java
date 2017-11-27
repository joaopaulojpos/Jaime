package com.jaime.jaime.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jaime.jaime.R;
import com.jaime.jaime.adapter.EstabelecimentoAdapter;
import com.jaime.jaime.domain.Estabelecimento;
import com.jaime.jaime.enums.EstabelecimentosEnum;

import java.util.ArrayList;
import java.util.List;

public class SelecionarLocalActivity extends AppCompatActivity {

    //ATRIBUTOS

    List<Estabelecimento> estabelecimentos;
    EstabelecimentoAdapter adapter;
    ListView listView;

    //METODOS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_local);


        estabelecimentos = new ArrayList<Estabelecimento>();
        alimentarEstabelecimentos();
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
                    Toast.makeText(SelecionarLocalActivity.this, "Estabelecimento: " + estabelecimento.nome + " selecionado.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void alimentarEstabelecimentos() {
        Estabelecimento e1 = new Estabelecimento();
        e1.nome = "Teatro de Santa Isabel";
        e1.descricao = "O Teatro de Santa Isabel é um teatro localizado na cidade brasileira do Recife, capital do estado de Pernambuco. É um raro exemplo de genuína arquitetura neoclássica da primeira metade do século XIX brasileiro.";
        e1.isPontoTuristico = true;
        e1.isLocalPublico = false;
        e1.endereco = "Praça da República, s/n - Santo Antônio, Recife - PE, 50010-040";
        e1.telefone = "(81) 3355-3323";
        e1.tipoEstabelecimento = EstabelecimentosEnum.TEATRO.toString();
        e1.imagem = 0;

        estabelecimentos.add(e1);
    }


}
