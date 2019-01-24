package com.example.administrator.weather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2019/1/23.
 */

public class Weather {
    public String status;
    public Basic basic;
    public AQI aqi;
    public Now now;
    public Suggestion suggestion;

    //由于daily_forecase中包含的是一个数组，
    //这里使用List集合来引用Forecast类
    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;

}
