package com.yaroslavm87.weatherapitest.Model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


public class CloudsDeserializer implements JsonDeserializer<Clouds> {

    @Override
    public Clouds deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        Clouds clouds = new Clouds();

        if(jsonObject.get("all") != null) {
            clouds.setAll(jsonObject.get("all").getAsInt());
        }

        return clouds;
    }
}
