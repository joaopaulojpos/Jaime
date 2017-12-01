package com.jaime.jaime.apiclima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jaime.jaime.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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

        addData();
    }

    /*
        Metodo criado para adicionar dados na lista
     */
    private void addData(){

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        for(int i = 1; i <= 30; i++) {
            Call<Clima> call = apiService.getPokemon(i);
            call.enqueue(new Callback<Clima>() {
                @Override
                public void onResponse(Call<Clima> call, Response<Clima> response) {
                    if(response.isSuccessful()) {
                        Clima clima = response.body();

                        climaList.add(clima);
                        climaAdapter.notifyDataSetChanged();

                        Log.i("CLIMA", "Description: " + clima.getDescription());
                        Log.i("CLIMA", "Condtion: " + clima.getCondition());

                    }
                }

                @Override
                public void onFailure(Call<Clima> call, Throwable t) {
                }
            });
        }
    }

}
