package com.jaime.jaime.activity;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jaime.jaime.R;
import com.jaime.jaime.fragment.DetalheFragment;
import com.jaime.jaime.fragment.ListaFragment;
import com.jaime.jaime.util.UtilTela;

public class SelecionarLocalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_local);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.containerFragmentList, new ListaFragment(), "TAGFragmentLista");
        fragmentTransaction.commit();
    }
}
