package com.jaime.jaime.teste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jaime.jaime.R;
import com.jaime.jaime.dao.EstabelecimentoDAO;
import com.jaime.jaime.domain.Estabelecimento;
import com.jaime.jaime.enums.EstabelecimentosEnum;

import java.util.ArrayList;
import java.util.List;

public class TesteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        Log.i("Leandro", "Antes de Resetar");
        EstabelecimentoDAO dao = new EstabelecimentoDAO(TesteActivity.this);

        List<Estabelecimento> lista = new ArrayList<>();
        lista = dao.listarEstabelecimentos(EstabelecimentosEnum.SHOPPING.toString());
        for(Estabelecimento x : lista){
            Log.i("Leandro", x.getNome());
            Log.i("Leandro", "Latitude: " + x.getLatitude() + "\nLongitude: " + x.getLongitude());
        }



        Log.i("Leandro", "Após Resetar:");
        dao.resetarEstabelecimenteos();

        lista = new ArrayList<>();
        lista = dao.listarEstabelecimentos(EstabelecimentosEnum.SHOPPING.toString());
        for(Estabelecimento x : lista){
            Log.i("Leandro", x.getNome());
            Log.i("Leandro", "Latitude: " + x.getLatitude() + "\nLongitude: " + x.getLongitude());
        }
    }
}
