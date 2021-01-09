package com.yaroslavm87.weatherapitest.Model;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class SnowDeserializer implements JsonDeserializer<Snow> {

    private final String TAG = "MyLogs";

    @Override
    public Snow deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Log.i(TAG, json.toString());

        Snow snow = new Snow();

        JsonObject jsonObject = json.getAsJsonObject();

        if(jsonObject.get("1h") != null) {
            snow.setH1(jsonObject.get("1h").getAsDouble());
        }

        if(jsonObject.get("3h") != null) {
            snow.setH3(jsonObject.get("1h").getAsDouble());
        }

        return snow;
    }
}
