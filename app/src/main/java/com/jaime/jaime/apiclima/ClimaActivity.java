package com.jaime.jaime.apiclima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jaime.jaime.R;

import java.util.ArrayList;
import java.util.List;


public class ClimaActivity extends AppCompatActivity {

    List<Clima> climaList = new ArrayList<>();
    RecyclerView recyclerView;
    ClimaAdapter climaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clima);

        /**
         * IMPLEMENTANDO O RecyclerView
         */
        recyclerView = (RecyclerView) findViewById(R.id.rv_climas);

        climaAdapter = new ClimaAdapter(climaList);

        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(climaAdapter);
    }
}
