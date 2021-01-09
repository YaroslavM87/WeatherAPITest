package com.yaroslavm87.weatherapitest.Model;

public class Wind {

    private Double speed;
    private Double deg;
    private Double gust;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDeg() {
        return deg;
    }

    public void setDeg(Double deg) {
        this.deg = deg;
    }

    public Double getGust() {
        return gust;
    }

    public void setGust(Double gust) {
        this.gust = gust;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("");

        if(speed != null || deg != null || gust != null) {
            sb.append("\n\nWind:");
        }

        if(speed != null) {
            sb.append("\n- speed (mps): ");
            sb.append(speed);
        }

        if(deg != null) {
            sb.append("\n- direction (degrees): ");
            sb.append(deg);
        }

        if(gust != null) {
            sb.append("\n- gusts (mps): ");
            sb.append(gust);
        }

        return  sb.toString();
    }
}
