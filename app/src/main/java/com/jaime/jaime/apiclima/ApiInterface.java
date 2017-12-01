package com.jaime.jaime.apiclima;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Dell-PC on 30/11/2017.
 */

public interface ApiInterface {

    @GET("/weather/?format=json&woeid={id}")
    Call<Clima> getPokemon(@Path("id") int id);

}
