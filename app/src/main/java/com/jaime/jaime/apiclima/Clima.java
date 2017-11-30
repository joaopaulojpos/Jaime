package com.jaime.jaime.apiclima;

/**
 * Created by Dell-PC on 29/11/2017.
 */

public class Clima {

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
}
