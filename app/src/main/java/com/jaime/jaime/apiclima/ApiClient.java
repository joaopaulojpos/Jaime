package com.jaime.jaime.apiclima;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dell-PC on 30/11/2017.
 */

/**
 * A ApiClient representa o cliente que fará todas as requisições na HG Wather
 */

public class ApiClient {

    public static final String BASE_URL = "https://api.hgbrasil.com";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
