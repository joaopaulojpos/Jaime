package com.jaime.jaime.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jaime.jaime.R;

public class CategoriaEstabelecimentosActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRestaurante;
    private Button btnBar;
    private Button btnTeatro;
    private Intent intent;

    //ATRIBUTOS Teste commit


    //METODOS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_estabelecimentos);

        pegarReferencias();
        listenarBotoes();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRestaurante:
                Intent intentRestaurante = new Intent(CategoriaEstabelecimentosActivity.this, SelecionarLocalActivity.class);
                intentRestaurante.putExtra("Categoria", "Restaurante");
                startActivity(intentRestaurante);
                break;

            case R.id.btnBar:
                Intent intentBar = new Intent(CategoriaEstabelecimentosActivity.this, SelecionarLocalActivity.class);
                intentBar.putExtra("Categoria", "Bar");
                startActivity(intentBar);
                break;

            case R.id.btnTeatro:
                Intent intentTeatro = new Intent(CategoriaEstabelecimentosActivity.this, SelecionarLocalActivity.class);
                intentTeatro.putExtra("Categoria", "Teatro");
                startActivity(intentTeatro);
                break;
        }
    }

    public void pegarReferencias() {
        btnRestaurante = findViewById(R.id.btnRestaurante);
        btnBar = findViewById(R.id.btnBar);
        btnTeatro = findViewById(R.id.btnTeatro);
    }

    public void listenarBotoes() {
        btnRestaurante.setOnClickListener(this);
        btnBar.setOnClickListener(this);
        btnTeatro.setOnClickListener(this);
    }
}
