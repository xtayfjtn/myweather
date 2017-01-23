package com.example.zq.moreweather.tool;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.zq.moreweather.R;
import com.example.zq.moreweather.Weather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZQ on 2017/1/22.
 */

public class WeatherAdapter extends BaseAdapter {
    private Context context;
    private List<Weather> weathers = new ArrayList<Weather>();
    private LayoutInflater listContainer;
    private int layoutID;

    public WeatherAdapter(Context context, List<Weather> weathers, int layoutID) {
        this.context = context;
        this.layoutID = layoutID;
        this.weathers = weathers;
        this.listContainer = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return weathers.size();
    }

    @Override
    public Object getItem(int i) {
        return weathers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = listContainer.inflate(layoutID, viewGroup, false);
        TextView datetext = (TextView) view.findViewById(R.id.datetext);
        TextView daytext = (TextView) view.findViewById(R.id.weatherday);
        TextView nighttext = (TextView) view.findViewById(R.id.weathernight);
        TextView lowtemp = (TextView) view.findViewById(R.id.lowtemp);
        TextView hightemp = (TextView) view.findViewById(R.id.hightemp);
        TextView precip = (TextView) view.findViewById(R.id.precip);
        TextView winddtext = (TextView) view.findViewById(R.id.winddtext);
        TextView windscale = (TextView) view.findViewById(R.id.windscale);
        datetext.setText(weathers.get(i).getDate());
        daytext.setText(weathers.get(i).getText_day());
        nighttext.setText(weathers.get(i).getText_night());
        lowtemp.setText(weathers.get(i).getLow());
        hightemp.setText(weathers.get(i).getHigh());
        precip.setText(weathers.get(i).getPrecip());
        winddtext.setText(weathers.get(i).getWind_direction());
        windscale.setText(weathers.get(i).getWind_scale());
        return view;
    }
}
