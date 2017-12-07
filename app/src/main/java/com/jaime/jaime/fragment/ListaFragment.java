package com.jaime.jaime.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jaime.jaime.R;
import com.jaime.jaime.activity.EstabelecimentoInfoActivity;
import com.jaime.jaime.activity.SelecionarLocalActivity;
import com.jaime.jaime.adapter.EstabelecimentoAdapter;
import com.jaime.jaime.dao.EstabelecimentoDAO;
import com.jaime.jaime.domain.Estabelecimento;
import com.jaime.jaime.util.DarCargaNoBanco;
import com.jaime.jaime.util.UtilTela;

import java.util.ArrayList;
import java.util.List;

public class ListaFragment extends Fragment {

    View view;

    //ATRIBUTOS

    private Bundle extrasPaginaAnterior;
    private Bundle extrasProximaPagina;
    List<Estabelecimento> estabelecimentos;
    EstabelecimentoAdapter adapter;
    ListView listView;
    private String categoria;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);

        Log.i("Leandro", "Entrou no onCreateView do ListaFragment");
        pegarReferencias(view);
        Log.i("Leandro", "Pegou Referencias");
        pegarExtras();

        return view;
    }

    @Override
    public void onResume() {
        Log.i("Leandro", "Entrou no onResume");
        estabelecimentos = new ArrayList<>();
        DarCargaNoBanco darCargaNoBanco = new DarCargaNoBanco();

        //Pega do banco os Estabelecimentos da categoria escolhida
        estabelecimentos = listarEstabelecimentos(categoria);

        //se a lista estiver vazia quer dizer que o banco tá vazio, então...
        if (estabelecimentos.isEmpty()) {
            //Damos uma carga no banco por ex: Se o usuário quer listar os shoppings, esse método
            //darCarga vai inserir no banco todos os shoppings
            darCargaNoBanco.darCarga(getContext(), categoria);
            //agora quando for pegar do banco não vai mais vir vazia
            estabelecimentos = listarEstabelecimentos(categoria);
        }

        adapter = new EstabelecimentoAdapter(getContext(), estabelecimentos);

        listView.setAdapter(adapter);
//        adapter.notifyDataSetChanged(); //acho q não precisa disso aqui

        //Se tiver vazio mostra um ícone do Android(não tá funcionando)
//        listView.setEmptyView(getView().findViewById(android.R.id.empty));

        /**
         * Este metodo é para quando for clicado em um local, joga o usuario para uma tela com os
         * detalhes do local selecionado, se caso a orientação for Landscape será mostrado as informações
         * do local ao lado
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //pega o estabelecimento selecionado
                Estabelecimento estabelecimento = (Estabelecimento) adapterView.getItemAtPosition(position);

                if (estabelecimento != null) {

                    UtilTela utilTela = new UtilTela();
                    Configuration configuration = getResources().getConfiguration();
                    String orientacaoAtual = utilTela.descobrirOrientacao(configuration);
                    switch (orientacaoAtual) {
                        case "landscape":



                           Bundle bundle = new Bundle();
                           bundle.putString("idEstabelecimento", estabelecimento.getId() + "");



                            DetalheFragment detalheFragment = new DetalheFragment();
                            detalheFragment.setArguments(bundle);
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.containerFragmentDetalhe, detalheFragment, "TAGFragmentDetalhe");
                            fragmentTransaction.commit();
                            break;
                        case "portrait":
                            Intent intentProximaPagina = new Intent(getContext(), EstabelecimentoInfoActivity.class);
                            intentProximaPagina.putExtra("Estabelecimento", estabelecimento);
                            startActivity(intentProximaPagina);
                            break;
                    }
                }
            }
        });

        super.onResume();
    }

    private void limparTableEstabelecimentos(DarCargaNoBanco darCargaNoBanco) {
        new EstabelecimentoDAO(getContext()).resetarEstabelecimenteos();
        darCargaNoBanco.darCarga(getContext(), categoria);
        estabelecimentos = listarEstabelecimentos(categoria);
    }

    private void pegarReferencias(View view) {
        listView = (ListView) view.findViewById(R.id.lista);
    }


    private void pegarExtras() {
        extrasPaginaAnterior = getActivity().getIntent().getExtras();
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
        EstabelecimentoDAO dao = new EstabelecimentoDAO(getContext());
        lista = (List<Estabelecimento>) dao.listarEstabelecimentos(categoria);
        return lista;
    }

}
