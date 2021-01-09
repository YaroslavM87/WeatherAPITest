package com.yaroslavm87.weatherapitest.Model;

public class CurrentWeather extends WeatherObject {

    private Main main;
//    private Sys sys;
    private Coord coord;
    private Weather weather;
    private Clouds clouds;
    private Wind wind;
//    private Rain rain;
    private Snow snow;
    private String base;
    private Double visibility;
    private Integer dt;
    private Integer timezone;
    private Integer id;
    private String name;
    private Integer cod;
    private StringBuilder stringBuilder;

    public CurrentWeather() {
        this.stringBuilder = new StringBuilder();
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {

        stringBuilder.delete(0, stringBuilder.length());
        stringBuilder.append("");

        appendPlaceNameToTheString();

        if(coord != null) {
            stringBuilder.append(coord.toString());
        }

        appendTimezoneToTheString();

        if(weather != null) {
            stringBuilder.append(weather.toString());
        }

        if(main != null) {
            stringBuilder.append(main.toString());
        }

        if(wind != null) {
            stringBuilder.append(wind.toString());
        }

        //rain

        if(snow != null) {
            stringBuilder.append(snow.toString());
        }

        appendVisibilityToTheString();

        if(clouds != null) {
            stringBuilder.append(clouds.toString());
        }

        return  stringBuilder.toString();
    }

    private void appendPlaceNameToTheString() {
        if(name != null) {
            stringBuilder.append("Current weather for ")
                    .append(name);
        }
    }

    private void appendTimezoneToTheString() {
        if(timezone != null) {
            if(timezone > 0) {
                stringBuilder.append("\nTimezone: +");

            } else {
                stringBuilder.append("\nTimezone: ");
            }
            stringBuilder.append(timezone / 3600);
        }
    }

    private void appendVisibilityToTheString() {
        if(visibility != null) {
            stringBuilder.append("\n\nVisibility (meters): ")
                    .append(visibility);
        }
    }
}