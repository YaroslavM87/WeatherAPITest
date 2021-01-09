package com.yaroslavm87.weatherapitest.Model;

public class Clouds {

    private Integer all;

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("");

        if(all != null) {
            sb.append("\n\nClouds:");
            sb.append("\n- cloudiness (%): ");
            sb.append(all);
        }

        return  sb.toString();
    }
}
