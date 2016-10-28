/*
 * Copyright (C) 2016, TP-LINK TECHNOLOGIES CO., LTD.
 *
 * Builder.java
 *
 * WeatherState builder
 *
 * Author huanghaiqi, Created at 2016-10-28
 *
 * Ver 1.0, 2016-10-28, huanghaiqi, Create file.
 */

package com.halohoop.weatherviewlib.widgets.builder;

public abstract class Builder {
    public abstract Builder setWeatherType(WeatherState.WEATHER_TYPE weatherType);

    public abstract Builder setDropCount(int dropCount);

    public abstract Builder setDropSpeed(float dropSpeed);

    public abstract Builder setDropDirection(float dropDirection);

    public abstract Builder setWindStrength(float windStrength);

    public abstract WeatherState create();
}
