package com.jaime.jaime.apiclima;

import retrofit2.http.GET;

/**
 * Created by Dell-PC on 04/12/2017.
 */

/**
 * faz uma requisição juntando a url do get com a url base e mandando a resposta para Clima Resposta
 * Interface obrigatoria do retrofit
 */
public interface ClimaapiService{
    @GET("?format=json&woeid=455824")
    retrofit2.Call<ClimaResposta> obterListaClimas();
}
