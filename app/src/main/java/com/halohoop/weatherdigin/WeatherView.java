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

    //[share data]
    private ValueAnimator mValueAnimator;
    private int mDropCount = 30;
    private float mDropSpeed = 30;
    private float mDropDirection = 90;//0-180
    private float mWindStrength = -1;//-1-0-+1

    //决定移动的距离，在onMeature中被决定
    float mMoveDistanceX = 100;
    float mMoveDistanceY = 100;
    //[share data]

    private WEATHER_TYPE mWeatherType = WEATHER_TYPE.RAIN;

    //rain data
    private final float mMinRainWidthStroke = 0.5f;
    private final float mMaxRainWidthStroke = 2;
    //rain data

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

    public void setWeatherType(WEATHER_TYPE weatherType) {
        this.mWeatherType = weatherType;
        //create new seed
        switch (mWeatherType) {
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

    enum WEATHER_TYPE {
        RAIN, SNOW, HAIL/*冰雹*/, CLOUD
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
        createAnimAndStart();
    }

    private void createAnimAndStart() {
        createRainAnim();
    }

    private void createRainAnim() {
        ValueAnimator anim = ValueAnimator.ofFloat(0, 1);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.addListener(new AnimatorListenerAdapter() {
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
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float percent = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        anim.setDuration(250);
        anim.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mMoveDistanceX = getMeasuredWidth();
        mMoveDistanceY = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
    }
}
