/*
 * Copyright (C) 2016, TP-LINK TECHNOLOGIES CO., LTD.
 *
 * WeatherState.java
 *
 * Weather state wrapper.
 *
 * Author huanghaiqi, Created at 2016-10-28
 *
 * Ver 1.0, 2016-10-28, huanghaiqi, Create file.
 */

package com.halohoop.weatherviewlib.widgets.builder;

import android.graphics.PointF;

public abstract class WeatherState {
    //[share data]
    private int mDropCount = 1;//1-30
    private float mDropSpeed = 30;
    private float mDropDirection = 90;//0-180
    private float mWindStrength = -1;//-1-0-+1

    //决定移动的距离，在onMeature中被决定
    float mMoveDistanceX = 100;
    float mMoveDistanceY = 100;
    //[share data]

    protected WEATHER_TYPE mWeatherType = WEATHER_TYPE.RAIN;

    public enum WEATHER_TYPE {
        RAIN, SNOW, HAIL/*冰雹*/, CLOUD
    }

    public WeatherState(WEATHER_TYPE mWeatherType) {
        this.mWeatherType = mWeatherType;
    }

    class Seed {
        float mStartX;
        float mStartY;
        float mEndX;
        float mEndY;
        PointF startPointF;
        PointF endPointF;
        float mStrokeWidth;
    }

    public WEATHER_TYPE getWeatherType() {
        return mWeatherType;
    }

    public int getDropCount() {
        return mDropCount;
    }

    public void setDropCount(int dropCount) {
        this.mDropCount = dropCount;
    }

    public float getDropSpeed() {
        return mDropSpeed;
    }

    public void setDropSpeed(float dropSpeed) {
        this.mDropSpeed = dropSpeed;
    }

    public float getDropDirection() {
        return mDropDirection;
    }

    public void setDropDirection(float dropDirection) {
        this.mDropDirection = dropDirection;
    }

    public float getWindStrength() {
        return mWindStrength;
    }

    public void setWindStrength(float windStrength) {
        this.mWindStrength = windStrength;
    }

}
