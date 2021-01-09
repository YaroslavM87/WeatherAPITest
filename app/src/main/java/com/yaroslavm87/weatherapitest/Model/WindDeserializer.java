package com.yaroslavm87.weatherapitest.Model;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class WindDeserializer implements JsonDeserializer<Wind> {

    private final String TAG = "MyLogs";

    @Override
    public Wind deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Log.i(TAG, json.toString());

        Wind wind = new Wind();

        JsonObject jsonObject = json.getAsJsonObject();

        if(jsonObject.get("speed") != null) {
            wind.setSpeed(jsonObject.get("speed").getAsDouble());
        }

        if(jsonObject.get("deg") != null) {
            wind.setDeg(jsonObject.get("deg").getAsDouble());
        }

        if(jsonObject.get("gust") != null) {
            wind.setGust(jsonObject.get("gust").getAsDouble());
        }

        return wind;
    }
}
