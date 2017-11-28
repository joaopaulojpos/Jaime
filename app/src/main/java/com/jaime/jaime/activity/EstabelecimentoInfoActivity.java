package com.jaime.jaime.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jaime.jaime.R;
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
    }

    private void setarCamposDaTela() {
        tvTitulo.setText(estabelecimento.nome);
        tvDescricao.setText(estabelecimento.descricao);
        tvEndereco.setText(estabelecimento.endereco);
        tvHorario.setText(estabelecimento.horarioAbre + " até " + estabelecimento.horarioFecha);
        tvSite.setText(estabelecimento.site);
        tvTelefone.setText(estabelecimento.telefone);

        //Imagem
        Resources res = this.getResources();
        TypedArray imagens = res.obtainTypedArray(R.array.imagens);
        imagem.setImageDrawable(imagens.getDrawable(estabelecimento.imagem));

        ratingBarAvalie.setEnabled(true);
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
