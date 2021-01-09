package com.yaroslavm87.weatherapitest.Model;

public interface InputJsonParserToWeatherObj {

    WeatherObject parse(String inputJson);

}