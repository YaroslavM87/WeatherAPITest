package com.yaroslavm87.weatherapitest.Model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonParserToWeatherObjToCurrentWeather implements InputJsonParserToWeatherObj {

    private String inputJSON;
    private Gson parser;
    private final String TAG = "MyLogs";

    public JsonParserToWeatherObjToCurrentWeather() {
        this.parser = new GsonBuilder()
                .registerTypeAdapter(Clouds.class, new CloudsDeserializer())
                .registerTypeAdapter(Coord.class, new CoordDeserializer())
                .registerTypeAdapter(Main.class, new MainDeserializer())
                .registerTypeAdapter(Snow.class, new SnowDeserializer())
                .registerTypeAdapter(Weather.class, new WeatherDeserializer())
                .registerTypeAdapter(Wind.class, new WindDeserializer())
                .create();
    }

    @Override
    public CurrentWeather parse(String inputJson) {
        CurrentWeather cw = this.parser.fromJson(this.inputJSON, CurrentWeather.class);
        Log.i(TAG, "inputJSON string has been parsed to CurrentWeather object");
        return cw;
    }

    public String getInputJSON() {
        return inputJSON;
    }

    public void setInputJSON(String inputJson) {
        if(!inputJson.equals("")) {
            this.inputJSON = inputJson;
            Log.i(TAG, "inputJSON has been set");
        }
    }
}