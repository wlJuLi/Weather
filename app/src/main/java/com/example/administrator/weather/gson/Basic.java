package com.example.administrator.weather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2019/1/23.
 */

public class Basic {

    //"city"与cityName建立映射关系
    @SerializedName("city")
    public String cityName;

    //"id"与weatherId建立映射关系
    @SerializedName("id")
    public String weatherId;


    public Update update;

    public class Update{
        //"loc"与updateTime建立映射关系
        @SerializedName("loc")
        public String updateTime;
    }
}
