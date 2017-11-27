package com.jaime.jaime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnProximaPagina;
    private Intent intent;

    //ATRIBUTOS



    //METODOS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pegarReferencias();
        listenar();
    }

    private void listenar() {
        btnProximaPagina.setOnClickListener(this);
    }

    private void pegarReferencias() {
        btnProximaPagina = (Button) findViewById(R.id.btn1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                intent = new Intent(MainActivity.this, CategoriaEstabelecimentosActivity.class);
                startActivity(intent);
                break;
        }
    }

    //Teste Commit Leandro
}
