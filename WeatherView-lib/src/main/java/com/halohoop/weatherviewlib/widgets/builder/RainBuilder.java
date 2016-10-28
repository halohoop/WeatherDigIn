/*
 * Copyright (C) 2016, TP-LINK TECHNOLOGIES CO., LTD.
 *
 * RainBuilder.java
 *
 * Rain weather builder
 *
 * Author huanghaiqi, Created at 2016-10-28
 *
 * Ver 1.0, 2016-10-28, huanghaiqi, Create file.
 */

package com.halohoop.weatherviewlib.widgets.builder;

public class RainBuilder extends Builder {

    @Override
    public Builder setWeatherType(WeatherState.WEATHER_TYPE weatherType) {
        return this;
    }

    @Override
    public Builder setDropCount(int dropCount) {
        return this;
    }

    @Override
    public Builder setDropSpeed(float dropSpeed) {
        return this;
    }

    @Override
    public Builder setDropDirection(float dropDirection) {
        return this;
    }

    @Override
    public Builder setWindStrength(float windStrength) {
        return this;
    }

    @Override
    public WeatherState create() {
        return null;
    }
}
