package com.example.zq.moreweather;

/**
 * Created by ZQ on 2017/1/19.
 */

public class Weather {
    private String date;
    private String text_day;
    private String text_night;
    private String high;
    private String low;
    private String precip; //降水概率
    private String wind_direction;
    private String wind_scale;//风力等级

    public Weather(String date, String text_day, String text_night, String high, String low, String precip, String wind_direction, String wind_scale) {
        this.date = date;
        this.high = high;
        this.precip = precip;
        this.low = low;
        this.text_day = text_day;
        this.text_night = text_night;
        this.wind_direction = wind_direction;
        this.wind_scale = wind_scale;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getPrecip() {
        return precip;
    }

    public void setPrecip(String precip) {
        this.precip = precip;
    }

    public String getText_day() {
        return text_day;
    }

    public void setText_day(String text_day) {
        this.text_day = text_day;
    }

    public String getText_night() {
        return text_night;
    }

    public void setText_night(String text_night) {
        this.text_night = text_night;
    }

    public String getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    public String getWind_scale() {
        return wind_scale;
    }

    public void setWind_scale(String wind_scale) {
        this.wind_scale = wind_scale;
    }
}
