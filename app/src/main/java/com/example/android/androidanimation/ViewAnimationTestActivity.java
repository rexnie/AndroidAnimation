package com.example.android.androidanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;

public class ViewAnimationTestActivity extends AppCompatActivity
        implements View.OnClickListener {
    private static final String TAG = "ViewAnimationTestActivi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation_test);
        findViewById(R.id.btn_alpha_animation).setOnClickListener(this);
        findViewById(R.id.btn_rotate_animation).setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_alpha_animation:
                AlphaAnimation aa = new AlphaAnimation(0, 1);
                aa.setDuration(3000);
                v.startAnimation(aa);
                break;
            case R.id.btn_rotate_animation:
                RotateAnimation ra = new RotateAnimation(0, 360, 100, 100);
                ra.setDuration(3000);
                v.startAnimation(ra);
                break;
            default:
                Log.e(TAG, "onClick: ");
                break;
        }
    }
}
