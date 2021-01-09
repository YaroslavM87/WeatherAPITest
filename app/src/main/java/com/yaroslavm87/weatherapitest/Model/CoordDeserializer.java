package com.yaroslavm87.weatherapitest.Model;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class CoordDeserializer implements JsonDeserializer<Coord> {

    private final String TAG = "MyLogs";

    @Override
    public Coord deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Log.i(TAG, json.toString());

        Coord coord = new Coord();

        JsonObject jsonObject = json.getAsJsonObject();

        if(jsonObject.get("lon") != null) {
            coord.setLon(jsonObject.get("lon").getAsDouble());
        }

        if(jsonObject.get("lat") != null) {
            coord.setLat(jsonObject.get("lat").getAsDouble());
        }

        return coord;
    }
}
