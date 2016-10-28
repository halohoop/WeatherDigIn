package com.halohoop.weatherdigin;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View tv = findViewById(R.id.tv);
        final ObjectAnimator translationX = ObjectAnimator.ofFloat(tv, "translationY", 0, 720);
        translationX.setDuration(1000).setInterpolator(new LinearInterpolator());
        translationX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float translationY = (float) animation.getAnimatedValue("translationY");
                float pecent = translationY / 720f;
                float duration = 1000 + (pecent * (7000 - 1000));
                translationX.setDuration((long) duration);
            }
        });
        translationX.start();
    }
}
