package com.yaroslavm87.weatherapitest.Model;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;


public class WeatherDeserializer implements JsonDeserializer<Weather> {

    private final String TAG = "MyLogs";

    @Override
    public Weather deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Log.i(TAG, json.toString());

        Weather weather = new Weather();

        if(json.isJsonArray()) {

            JsonArray jsonArray = json.getAsJsonArray();

            JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();

            setWeatherObjValues(jsonObject, weather);
        }

        if(json.isJsonObject()) {

            JsonObject jsonObject = json.getAsJsonObject();

            setWeatherObjValues(jsonObject, weather);
        }

        if(!json.isJsonNull()) {

            String data = json.toString();

            List<String> parts = Arrays.asList(data.split(" "));
        }

        return weather;
    }

    private void setWeatherObjValues(JsonObject jsonObject, Weather weather) {

        if(jsonObject.get("main") != null) {
            weather.setMain(jsonObject.get("main").getAsString());
        }

        if(jsonObject.get("description") != null) {
            weather.setDescription(jsonObject.get("description").getAsString());
        }
    }
}
