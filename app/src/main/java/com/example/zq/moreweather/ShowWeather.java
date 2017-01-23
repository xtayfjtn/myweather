package com.example.zq.moreweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.zq.moreweather.tool.JSONAnlyse;
import com.example.zq.moreweather.tool.WeatherAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by ZQ on 2017/1/19.
 */

public class ShowWeather extends AppCompatActivity {
    private String citystr = "jinhua";
    private String url = "https://api.thinkpage.cn/v3/weather/daily.json?key=knxe9lycbgjpjstv&location=" + citystr
            + "&language=zh-Hans&unit=c&start=0&days=5";
    private JSONObject result;
    //private TextView text_test;
    private TextView cityname;
    private JSONAnlyse anlyseResult;
    private ListView listweather;
    RequestQueue requestQueue = null;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showweather);
        requestQueue = Volley.newRequestQueue(ShowWeather.this);
        cityname = (TextView) findViewById(R.id.test1);
        listweather = (ListView) findViewById(R.id.listdaily);

        Intent intent = super.getIntent();
        citystr = intent.getStringExtra("city");
        if (!citystr.equals("")) {
            try {
                citystr = URLEncoder.encode(citystr, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //cityname.setText(citystr);
            url = "https://api.thinkpage.cn/v3/weather/daily.json?key=knxe9lycbgjpjstv&location=" + citystr
                    + "&language=zh-Hans&unit=c&start=0&days=5/";
        }

        //Log.d("url", url);
        getJSONObject(new VolleyCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                try {
                    anlyseResult = new JSONAnlyse(result);
                    setPage(anlyseResult);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setPage(JSONAnlyse anlyseResult) {
        cityname.setText(anlyseResult.getCityname());
        //SimpleAdapter adapter = new SimpleAdapter();
        //Log.e("Adapter", "start");
        List<Weather> weathers = anlyseResult.getWeathers();
        WeatherAdapter adapter = new WeatherAdapter(ShowWeather.this, weathers, R.layout.listofdaily);
        listweather.setAdapter(adapter);
        //Log.e("Adapter", "end");
    }

    public void getJSONObject(final VolleyCallback callback) {
        JsonObjectRequest objectRequest = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject object) {
                        result = object;
                        callback.onSuccess(result);
                        //Log.d("TAG", result.toString());
                        //text_test.setText(object.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //text_test.setText("ahkq");'
                        //Log.e("WRONG", "NIHAOLE");
                        if (volleyError.getMessage() == null) {
                            Toast.makeText(ShowWeather.this, "Failed to get the source.", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.e("ShowWeather", volleyError.getMessage());
                        }
                        //volleyError.printStackTrace();
                        //Log.e("WRONG", "DFDFDF");
                        //Log.e("tag", volleyError.getMessage());
                    }
                }
        );
        requestQueue.add(objectRequest);
    }

    private interface VolleyCallback {
        void onSuccess(JSONObject result);
    }
}
