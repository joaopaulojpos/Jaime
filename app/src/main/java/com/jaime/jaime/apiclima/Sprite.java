package com.jaime.jaime.apiclima;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell-PC on 30/11/2017.
 */

/**
 * Utilizamos annotations para dizer onde cada atributo do objeto vindo da API será atribuído.
 * Assim, para cada @SerializedName(String) estamos vinculando
 * um valor da API a um atributo de nossas classes.
 */

public class Sprite {

    @SerializedName("description")
    private String desccription;

    @SerializedName("resource_uri")
    private String resourceUri;

    public Sprite(String desccription) {
        this.desccription = desccription;
    }

    public String getDesccription() {
        return desccription;
    }

    public void setDesccription(String desccription) {
        this.desccription = desccription;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }
}
