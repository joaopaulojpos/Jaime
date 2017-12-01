package com.jaime.jaime.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jaime.jaime.R;
import com.jaime.jaime.apiclima.Clima;

public class CategoriaEstabelecimentosActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRestaurante;
    private Button btnBar;
    private Button btnTeatro;
    private Button btnClima;
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
        intent = new Intent(CategoriaEstabelecimentosActivity.this, SelecionarLocalActivity.class);
        switch (v.getId()) {
            case R.id.btnRestaurante:
                intent.putExtra("Categoria", "Restaurante");
                break;
            case R.id.btnBar:
                intent.putExtra("Categoria", "Bar");
                break;
            case R.id.btnTeatro:
                intent.putExtra("Categoria", "Teatro");
                break;
        }
        startActivity(intent);
    }


    //Estou fazendo esse metodo aqui para chamar a activity de Clima.
    public void acionarClima(View view) {
        Intent intent = new Intent(this, Clima.class);
        startActivity(intent);
    }


    public void pegarReferencias() {
        btnRestaurante = findViewById(R.id.btnRestaurante);
        btnBar = findViewById(R.id.btnBar);
        btnTeatro = findViewById(R.id.btnTeatro);
        btnClima = findViewById(R.id.btnClima);
    }

    public void listenarBotoes() {
        btnRestaurante.setOnClickListener(this);
        btnBar.setOnClickListener(this);
        btnTeatro.setOnClickListener(this);
    }
}
