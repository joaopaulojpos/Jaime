package com.jaime.jaime.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jaime.jaime.MapsTeste.TesteMapsActivity;
import com.jaime.jaime.R;
import com.jaime.jaime.activity.EstabelecimentoInfoActivity;
import com.jaime.jaime.dao.EstabelecimentoDAO;
import com.jaime.jaime.domain.Estabelecimento;
import com.jaime.jaime.util.UtilTela;


public class DetalheFragment extends Fragment implements View.OnClickListener{

    private View view;

    //private Bundle extras;
    private Intent intent;
    Bundle bundle;
    private Estabelecimento estabelecimento;
    private TextView tvTitulo;
    private TextView tvDescricao;
    private TextView tvEndereco;
    private TextView tvHorario;
    private TextView tvTelefone;
    private TextView tvSite;
    private RatingBar ratingBarAvalie;
    private CheckBox checkBoxFavorito;
    private ImageView imagem;
    private TextInputEditText txtInputEditTextAnotacao;
    private Float nota;
    private TextView tvVerLocalizacao;
    private ImageView imgLogoMaps;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detalhe, container, false);
        pegarExtras();
        pegarReferencias(view);
        listenar();
        Log.i("Leandro", "onCreateView: listener ok");


        return view;
    }

    @Override
    public void onResume() {
        setarCamposDaTela();
        Log.i("Leandro", "onCreateView: setou campos na tela");
        pegarRating();
        Log.i("Leandro", "onCreateView: pegou rating");

        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();

        avaliarSQLite();

        favoritarSQLite();

        anotacaoSQLite();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), TesteMapsActivity.class);
        switch (v.getId()) {
            case R.id.tvMaps:
                abrirNoMapa(intent);
                break;
            case R.id.imgLogoMaps:
                abrirNoMapa(intent);
                break;
        }
    }

    private void listenar() {
        tvVerLocalizacao.setOnClickListener(this);
        checkBoxFavorito.setOnClickListener(this);
        imgLogoMaps.setOnClickListener(this);
    }

    private void anotacaoSQLite() {
        estabelecimento.setAnotacao(txtInputEditTextAnotacao.getText().toString());
        EstabelecimentoDAO dao = new EstabelecimentoDAO(getContext());
        dao.atualizarEstabelecimento(estabelecimento);
    }

    private void favoritarSQLite() {
        if (checkBoxFavorito.isChecked()) {
            adicionarAosFavoritos(estabelecimento);
        } else {
            removerDosFavoritos(estabelecimento);
        }
    }

    private void avaliarSQLite() {
        if (nota != null) {
            EstabelecimentoDAO dao = new EstabelecimentoDAO(getContext());
            estabelecimento.setNota(nota);
            dao.atualizarEstabelecimento(estabelecimento);
        }

    }

    private void pegarRating() {
        ratingBarAvalie.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                nota = rating;
            }
        });
    }

    private void setarCamposDaTela() {
        tvTitulo.setText("Oi");
        Log.i("Leandro", "setarCamposDaTela: setou na mão");
        tvTitulo.setText(estabelecimento.getNome());
        tvDescricao.setText(estabelecimento.getDescricao());
        tvEndereco.setText(estabelecimento.getEndereco());
        tvHorario.setText(estabelecimento.getHorarioAbre() + " até " + estabelecimento.getHorarioFecha());
        tvSite.setText(estabelecimento.getSite());
        tvTelefone.setText(estabelecimento.getTelefone());
        ratingBarAvalie.setRating(estabelecimento.getNota());
        if (estabelecimento.getAnotacao() != null) {
            txtInputEditTextAnotacao.setText(estabelecimento.getAnotacao());
        }


        //Imagem
        Resources res = this.getResources();
        TypedArray imagens = res.obtainTypedArray(R.array.imagens);
        imagem.setImageDrawable(imagens.getDrawable(estabelecimento.getImagem()));


        if (estabelecimento.getIsFavorito() == 1) {
            checkBoxFavorito.setChecked(true);
        }

    }


    private void pegarReferencias(View view) {
        tvTitulo = (TextView) view.findViewById(R.id.tvTitulo1);
        tvDescricao = (TextView) view.findViewById(R.id.tvDescricao);
        tvEndereco = (TextView) view.findViewById(R.id.tvEndereco2);
        tvHorario = (TextView) view.findViewById(R.id.tvHorario2);
        tvTelefone = (TextView) view.findViewById(R.id.tvTelefone2);
        tvSite = (TextView) view.findViewById(R.id.tvSite2);
        ratingBarAvalie = (RatingBar) view.findViewById(R.id.ratingBar);
        checkBoxFavorito = (CheckBox) view.findViewById(R.id.cbFav);
        imgLogoMaps = (ImageView) view.findViewById(R.id.imgLogoMaps);

        imagem = (ImageView) view.findViewById(R.id.imgEstabelecimento);
        txtInputEditTextAnotacao = (TextInputEditText) view.findViewById(R.id.txtInputEditTextAnotacao);
        tvVerLocalizacao = (TextView) view.findViewById(R.id.tvMaps);
    }

    private void pegarExtras() {
        try {


            UtilTela utilTela = new UtilTela();
            Configuration configuration = getResources().getConfiguration();
            String orientacaoAtual = utilTela.descobrirOrientacao(configuration);
            View view = null;
            switch (orientacaoAtual) {
                case "landscape":
                    estabelecimento = new Estabelecimento();

                    Bundle bundle = getArguments();
                    estabelecimento.setId(Integer.parseInt(bundle.getString("idEstabelecimento")));
                    Log.i("Leandro", "pegarExtras Land: Estabelecimento: " + estabelecimento.getId());
                    break;
                case "portrait":
                    intent = getActivity().getIntent();
                    estabelecimento = (Estabelecimento) intent.getSerializableExtra("Estabelecimento");
                    Log.i("Leandro", "pegarExtras portrait: Estabelecimento: " + estabelecimento.getId());
                    break;
            }

            estabelecimento = new EstabelecimentoDAO(getContext()).listarEstabelecimento(estabelecimento.getId());
            Log.i("Leandro", "pegarExtras: Estabelecimento pós DAO: " + estabelecimento.getNome());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void abrirNoMapa(Intent intent) {
        intent.putExtra("latitude", new Double(estabelecimento.getLatitude()));
        intent.putExtra("longitude", new Double(estabelecimento.getLongitude()));
        intent.putExtra("nomeLocal", estabelecimento.getNome());
        startActivity(intent);
    }

    private void removerDosFavoritos(Estabelecimento estabelecimento) {
        estabelecimento.setIsFavorito(0);
        EstabelecimentoDAO dao = new EstabelecimentoDAO(getContext());
        dao.atualizarEstabelecimento(estabelecimento);
    }

    private void adicionarAosFavoritos(Estabelecimento estabelecimento) {
        estabelecimento.setIsFavorito(1);
        EstabelecimentoDAO dao = new EstabelecimentoDAO(getContext());
        dao.atualizarEstabelecimento(estabelecimento);
    }


}
