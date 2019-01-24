package com.example.administrator.weather.util;

import android.text.TextUtils;

import com.example.administrator.weather.db.City;
import com.example.administrator.weather.db.County;
import com.example.administrator.weather.db.Province;
import com.example.administrator.weather.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2019/1/23.
 */

public class Utility {

    /*解析和处理服务器返回的省级数据*/
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                //json的对象的数组，用来接收传回的多个省份的数据
                JSONArray allProvinces = new JSONArray(response);
                for (int i=0;i<allProvinces.length();i++){
                    //取出每一个省份
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    //解析出省份的id并将其赋值给province对象
                    province.setPrivinceCode(provinceObject.getInt("id"));
                    //解析出省份的name并将其赋值给province对象
                    province.setProvinceNane(provinceObject.getString("name"));
                    //将这一个省份保存到表中
                    province.save();
                }
                //处理成功返回真
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        //处理失败返回为假
        return false;
    }

    public static boolean handleCityResponse(String response,int provinceId){
        //处理和解析市的数据
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities=new JSONArray(response);
                for (int i=0;i<allCities.length();i++){
                    JSONObject cityObject=allCities.getJSONObject(i);
                    City city=new City();
                    city.setCityCode(cityObject.getInt("id"));
                    city.setCityName(cityObject.getString("name"));
                    city.setProvinceId(provinceId);
                    city.save();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public static boolean handleCountyResponse(String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties=new JSONArray(response);
                for (int i=0;i<allCounties.length();i++){
                    JSONObject countyObject=allCounties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setCityId(cityId);
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("HeWeather");
            String weatherContent=jsonArray.getJSONObject(0).toString();
            //将json数据转化为Weather对象
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
