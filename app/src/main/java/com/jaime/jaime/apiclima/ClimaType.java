package com.jaime.jaime.apiclima;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell-PC on 30/11/2017.
 */

public class ClimaType {

    @SerializedName("description")
    private String description;

    public ClimaType(String description) {
        this.description = description;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
