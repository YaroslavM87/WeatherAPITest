package com.yaroslavm87.weatherapitest.Model;

public class Coord {

    private Double lon;
    private Double lat;

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("");

        if(lon != null & lat != null) {
            sb.append("\nCoordinates: \n- longitude: ");
            sb.append(lon);

            sb.append("\n- latitude: ");
            sb.append(lat);
        }

        return sb.toString();
    }
}
