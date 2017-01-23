package com.example.zq.moreweather.tool;

import android.util.Log;

import com.example.zq.moreweather.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZQ on 2017/1/21.
 */

public class JSONAnlyse {
    private List<Weather> weathers = new ArrayList<Weather>();

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    private String cityname;

    public JSONAnlyse(JSONObject object) throws JSONException {
        JSONArray result = object.getJSONArray("results");
        JSONObject resultObject = result.getJSONObject(0);
        JSONObject location = resultObject.getJSONObject("location");
        cityname = location.getString("name");
        JSONArray daily = resultObject.getJSONArray("daily");
        for (int i = 0; i < daily.length(); i++) {
            JSONObject object1 = daily.getJSONObject(i);
            //Log.e("daily", object1.toString());
            String date = object1.getString("date");
            String text_day = object1.getString("text_day");
            String text_night = object1.getString("text_night");
            String high = object1.getString("high");
            String low = object1.getString("low");
            String precip = object1.getString("precip"); //降水概率
            String wind_direction = object1.getString("wind_direction");
            String wind_scale = object1.getString("wind_scale");//风力等级
            Weather weather = new Weather(date, text_day, text_night, high, low, precip, wind_direction, wind_scale);
            weathers.add(weather);
        }
    }
}
