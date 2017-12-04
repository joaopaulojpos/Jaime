package com.jaime.jaime.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jaime.jaime.R;
import com.jaime.jaime.dao.EstabelecimentoDAO;
import com.jaime.jaime.domain.Estabelecimento;


public class EstabelecimentoInfoActivity extends AppCompatActivity implements View.OnClickListener {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estabelecimento_info);
        pegarExtras();
        pegarReferencias();
        setarCamposDaTela();
        pegarRating();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        avaliarSQLite();

        favoritarSQLite();

        anotacaoSQLite();
    }

    private void anotacaoSQLite() {
        estabelecimento.setAnotacao(txtInputEditTextAnotacao.getText().toString());
        EstabelecimentoDAO dao = new EstabelecimentoDAO(this);
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
            EstabelecimentoDAO dao = new EstabelecimentoDAO(EstabelecimentoInfoActivity.this);
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

    private void pegarReferencias() {
        tvTitulo = (TextView) findViewById(R.id.tvTitulo1);
        tvDescricao = (TextView) findViewById(R.id.tvDescricao2);
        tvEndereco = (TextView) findViewById(R.id.tvEndereco2);
        tvHorario = (TextView) findViewById(R.id.tvHorario2);
        tvTelefone = (TextView) findViewById(R.id.tvTelefone2);
        tvSite = (TextView) findViewById(R.id.tvSite2);
        ratingBarAvalie = (RatingBar) findViewById(R.id.ratingBar2);
        checkBoxFavorito = (CheckBox) findViewById(R.id.cbFav);
        checkBoxFavorito.setOnClickListener(this);
        imagem = (ImageView) findViewById(R.id.img1);
        txtInputEditTextAnotacao = (TextInputEditText) findViewById(R.id.txtInputEditTextAnotacao);
    }


    private void pegarExtras() {
        try {
            intent = getIntent();
            estabelecimento = (Estabelecimento) intent.getSerializableExtra("Estabelecimento");
            estabelecimento = new EstabelecimentoDAO(this).listarEstabelecimento(estabelecimento.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {

    }

    private void removerDosFavoritos(Estabelecimento estabelecimento) {
        estabelecimento.setIsFavorito(0);
        EstabelecimentoDAO dao = new EstabelecimentoDAO(this);
        dao.atualizarEstabelecimento(estabelecimento);
    }

    private void adicionarAosFavoritos(Estabelecimento estabelecimento) {
        estabelecimento.setIsFavorito(1);
        EstabelecimentoDAO dao = new EstabelecimentoDAO(this);
        dao.atualizarEstabelecimento(estabelecimento);
    }
}
