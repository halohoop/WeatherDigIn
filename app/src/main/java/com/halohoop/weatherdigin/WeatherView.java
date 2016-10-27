/*
 * Copyright (C) 2016, TP-LINK TECHNOLOGIES CO., LTD.
 *
 * WeatherView.java
 *
 * WeatherView to show different weather
 *
 * Author huanghaiqi, Created at 2016-10-27
 *
 * Ver 1.0, 2016-10-27, huanghaiqi, Create file.
 */

package com.halohoop.weatherdigin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class WeatherView extends View {

    //share data
    private ValueAnimator mValueAnimator;
    private int mDropCount = 30;
    private float mDropSpeed = 30;
    private float mDropDirection = 90;//0-180
    private float mWindStrength = -1;//-1-0-+1

    //rain data
    private float mMinRainWidthStroke = 0.5f;
    private float mMaxRainWidthStroke = 2;


    public WeatherView(Context context) {
        this(context, null);
    }

    public WeatherView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private WEATHER_TYPE mWeatherType = WEATHER_TYPE.RAIN;

    enum WEATHER_TYPE {
        RAIN, SNOW, HAIL/*冰雹*/, CLOUD
    }

    float moveDistanceX;
    float moveDistanceY;

    class RainSeed {
        float mStartX;
        float mStartY;
        float mEndX;
        float mEndY;
        PointF startPointF;
        PointF endPointF;
        float mStrokeWidth;
    }

    private void init() {
    }

    public void startDrop() {
        switch (mWeatherType) {
            case RAIN:
                createAnimAndStart();
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

    private void createAnimAndStart() {
        if (mValueAnimator == null) {
            mValueAnimator = ValueAnimator.ofFloat(0, 100);
            mValueAnimator.setInterpolator(new LinearInterpolator());
            mValueAnimator.setRepeatMode(ValueAnimator.INFINITE);
            mValueAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationPause(Animator animation) {
                    super.onAnimationPause(animation);
                }
            });
            mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    invalidate();
                }
            });
            mValueAnimator.start();
        } else {
            if (mValueAnimator.isPaused()) {
                mValueAnimator.resume();
                return;
            }
            if (mValueAnimator.isStarted() || mValueAnimator.isRunning()) {
                return;
            } else {
                mValueAnimator.start();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

    }
}
