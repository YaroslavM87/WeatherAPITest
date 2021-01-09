package com.yaroslavm87.weatherapitest.Model;

public class Main {

    private Double temp;
    private Double feels_like;
    private Double pressure;
    private Double humidity;
    private Double temp_min;
    private Double temp_max;
    private Double sea_level;
    private Double grnd_level;

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Double feels_like) {
        this.feels_like = feels_like;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }

    public Double getSea_level() {
        return sea_level;
    }

    public void setSea_level(Double sea_level) {
        this.sea_level = sea_level;
    }

    public Double getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(Double grnd_level) {
        this.grnd_level = grnd_level;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");

        if(temp != null || feels_like != null || humidity != null || pressure != null) {
            sb.append("\n\nMain:");
        }

        if(temp != null) {
            sb.append("\n- current temperature (celsius): ");
            sb.append(temp);
        }

        if(feels_like != null) {
            sb.append("\n- feels like: ");
            sb.append(feels_like);
        }

//        if(temp_min != null) {
//            sb.append("\n- min temperature: ");
//            sb.append(temp_min);
//        }
//
//        if(temp_max != null) {
//            sb.append("\n- max temperature: ");
//            sb.append(temp_max);
//        }

        if(humidity != null) {
            sb.append("\n- humidity (%): ");
            sb.append(humidity);
        }

        if(pressure != null) {
            sb.append("\n- atmospheric pressure (hPa): ");
            sb.append(pressure);
        }

//        if(grnd_level != null) {
//            sb.append("\n- atmospheric pressure on the ground level (hPa): ");
//            sb.append(grnd_level);
//        }
//
//        if(sea_level != null) {
//            sb.append("\n- atmospheric pressure on the sea level (hPa): ");
//            sb.append(sea_level);
//        }

        return  sb.toString();
    }
}
