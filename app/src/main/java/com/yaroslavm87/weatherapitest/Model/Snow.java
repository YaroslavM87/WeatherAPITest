package com.yaroslavm87.weatherapitest.Model;

public class Snow {

    private Double h1;
    private Double h3;

    public Double getH1() {
        return h1;
    }

    public void setH1(Double h1) {
        this.h1 = h1;
    }

    public Double getH3() {
        return h3;
    }

    public void setH3(Double h3) {
        this.h3 = h3;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("");

        if(h1 != null || h3 != null) {
            sb.append("\n\nSnow:");
        }

        if(h1 != null) {
            sb.append("\n- precip. for 1h (mm): ");
            sb.append(h1);
        }

        if(h3 != null) {
            sb.append("\n- precip. for 3h (mm): ");
            sb.append(h3);
        }

        return  sb.toString();
    }
}
