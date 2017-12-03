package com.jaime.jaime.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jaime.jaime.R;
import com.jaime.jaime.dao.EstabelecimentoDAO;
import com.jaime.jaime.domain.Estabelecimento;


public class EstabelecimentoInfoActivity extends AppCompatActivity {

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
    private CheckBox chkFav;
    private ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estabelecimento_info);

        pegarExtras();
        pegarReferencias();
        setarCamposDaTela();

        avaliarEstabelecimento();
    }

    @Override
    protected void onResume() {
        super.onResume();
        float notaa = new EstabelecimentoDAO(EstabelecimentoInfoActivity.this).listarEstabelecimento(estabelecimento.getId()).getNota();
        ratingBarAvalie.setRating(notaa);

        Log.i("Leandro", "Resume:\ngetNota: " + estabelecimento.getNota());
    }

    private void avaliarEstabelecimento() {
        ratingBarAvalie.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                EstabelecimentoDAO dao = new EstabelecimentoDAO(EstabelecimentoInfoActivity.this);
                estabelecimento.setNota(rating);
                dao.atualizarEstabelecimento(estabelecimento);
                ratingBarAvalie.setRating(rating);
                Log.i("Leandro", "Clickou:\ngetNota: " + estabelecimento.getNota());
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void setarCamposDaTela() {
        tvTitulo.setText(estabelecimento.getNome());
        tvDescricao.setText(estabelecimento.getDescricao());
        tvEndereco.setText(estabelecimento.getEndereco());
        tvHorario.setText(estabelecimento.getHorarioAbre() + " até " + estabelecimento.getHorarioFecha());
        tvSite.setText(estabelecimento.getSite());
        tvTelefone.setText(estabelecimento.getTelefone());

        //Imagem
        Resources res = this.getResources();
        TypedArray imagens = res.obtainTypedArray(R.array.imagens);
        imagem.setImageDrawable(imagens.getDrawable(estabelecimento.getImagem()));

    }

    private void pegarReferencias() {
        tvTitulo = (TextView) findViewById(R.id.tvTitulo1);
        tvDescricao = (TextView) findViewById(R.id.tvDescricao2);
        tvEndereco = (TextView) findViewById(R.id.tvEndereco2);
        tvHorario = (TextView) findViewById(R.id.tvHorario2);
        tvTelefone = (TextView) findViewById(R.id.tvTelefone2);
        tvSite = (TextView) findViewById(R.id.tvSite2);
        ratingBarAvalie = (RatingBar) findViewById(R.id.ratingBar2);
        chkFav = (CheckBox) findViewById(R.id.cbFav);
        imagem = (ImageView) findViewById(R.id.img1);
    }


    private void pegarExtras() {
        intent = getIntent();
        estabelecimento = (Estabelecimento) intent.getSerializableExtra("Estabelecimento");
    }

}
