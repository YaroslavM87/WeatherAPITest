package com.yaroslavm87.weatherapitest.Model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;


public class MainDeserializer implements JsonDeserializer<Main> {

    @Override
    public Main deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        Main main = new Main();

        if(jsonObject.get("temp") != null) {
            main.setTemp(jsonObject.get("temp").getAsDouble());
        }

        if(jsonObject.get("feels_like") != null) {
            main.setFeels_like(jsonObject.get("feels_like").getAsDouble());
        }


        if(jsonObject.get("temp_min") != null) {
            main.setTemp_min(jsonObject.get("temp_min").getAsDouble());
        }

        if(jsonObject.get("temp_max") != null) {
            main.setTemp_max(jsonObject.get("temp_max").getAsDouble());
        }

        if(jsonObject.get("humidity") != null) {
            main.setHumidity(jsonObject.get("humidity").getAsDouble());
        }

        if(jsonObject.get("pressure") != null) {
            main.setPressure(jsonObject.get("pressure").getAsDouble());
        }

        if(jsonObject.get("sea_level") != null) {
            main.setSea_level(jsonObject.get("sea_level").getAsDouble());
        }

        if(jsonObject.get("grnd_level") != null) {
            main.setGrnd_level(jsonObject.get("grnd_level").getAsDouble());
        }

        return main;
    }
}
