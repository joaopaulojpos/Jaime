package com.jaime.jaime.apiclima;

import retrofit2.http.GET;

/**
 * Created by Dell-PC on 04/12/2017.
 */

public interface ClimaapiService{
    @GET("?format=json&woeid=455824")
    retrofit2.Call<ClimaResposta> obterListaClimas();
}
