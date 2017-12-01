package com.jaime.jaime.apiclima;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell-PC on 29/11/2017.
 */

public class Clima {

    @SerializedName("description")
    private String description;

    @SerializedName("condition")
    private String condition;

    @SerializedName("sprites")
    private List<Sprite> sprites = new ArrayList<>();

    @SerializedName("types")
    private List<ClimaType> climaTypes = new ArrayList<>();

    public Clima(String description, String condition, List<Sprite> sprites, List<ClimaType> climaTypes) {
        this.description = description;
        this.condition = condition;
        this.sprites = sprites;
        this.climaTypes = climaTypes;
    }

    public String climaTypesToString() {
        String types = "";
        for (int i = 0; i < climaTypes.size(); i++) {
            if(i > 0)
                types += ", ";
            types += climaTypes.get(i).getDescription();
        }

        return types;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<Sprite> getSprites() {
        return sprites;
    }

    public void setSprites(List<Sprite> sprites) {
        this.sprites = sprites;
    }

    public List<ClimaType> getClimaTypes() {
        return climaTypes;
    }

    public void setClimaTypes(List<ClimaType> climaTypes) {
        this.climaTypes = climaTypes;
    }

    /**
    private String description;
    private String condition;

    public Clima(){

    }

    public Clima(String description, String condition) {
        this.description = description;
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
     */
}
