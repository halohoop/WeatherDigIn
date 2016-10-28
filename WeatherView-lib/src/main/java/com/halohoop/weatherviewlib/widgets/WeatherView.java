/*
 * Copyright (C) 2016, TP-LINK TECHNOLOGIES CO., LTD.
 *
 * WeatherView.java
 *
 * Custom View  to Show Weather 
 *
 * Author huanghaiqi, Created at 2016-10-28
 *
 * Ver 1.0, 2016-10-28, huanghaiqi, Create file.
 */

package com.halohoop.weatherviewlib.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.halohoop.weatherviewlib.widgets.builder.WeatherState;

public class WeatherView extends View {
    private WeatherState mWeatherType;

    public WeatherView(Context context) {
        this(context, null);
    }

    public WeatherView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public WeatherState getWeatherType() {
        return mWeatherType;
    }

    public void setWeatherType(WeatherState weatherType) {
        this.mWeatherType = weatherType;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //create new seed
        switch (mWeatherType.getWeatherType()) {
            case RAIN:
                break;
            case SNOW:
                break;
            case HAIL:
                break;
            case CLOUD:
                break;
            default:
                break;
        }
    }
}
