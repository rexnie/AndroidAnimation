package com.example.android.androidanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

public class AnimationSampleMenuActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "AnimationSampleMenu";
    private ImageView mImageViewApp;
    private ImageView mImageViewLocation;
    private ImageView mImageViewMusic;
    private ImageView mImageViewCamera;
    private ImageView mImageViewSetting;
    private boolean mFlag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_sample_menu);

        mImageViewApp = (ImageView) findViewById(R.id.iv_app);
        mImageViewLocation = (ImageView) findViewById(R.id.iv_map_location);
        mImageViewMusic = (ImageView) findViewById(R.id.iv_music);
        mImageViewCamera = (ImageView) findViewById(R.id.iv_camera);
        mImageViewSetting = (ImageView) findViewById(R.id.iv_setting);

        mImageViewApp.setOnClickListener(this);
        mImageViewLocation.setOnClickListener(this);
        mImageViewMusic.setOnClickListener(this);
        mImageViewCamera.setOnClickListener(this);
        mImageViewSetting.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_app:
                Log.d(TAG, "onClick: mFlag=" + mFlag);
                if (mFlag) {
                    startAnimation();
                } else {
                    closeAnimation();
                }
                break;
            default:
                Log.d(TAG, "onClick: id = " + v.getId());
                break;
        }
    }

    private void startAnimation() {
        ObjectAnimator oaApp = ObjectAnimator.ofFloat(
                mImageViewApp, "alpha", 1f, 0.5f);
        ObjectAnimator oaLocation = ObjectAnimator.ofFloat(
                mImageViewLocation, "translationY", 200f);
        ObjectAnimator oaMusic = ObjectAnimator.ofFloat(
                mImageViewMusic, "translationX", 200f);
        ObjectAnimator oaCamera = ObjectAnimator.ofFloat(
                mImageViewCamera, "translationY", -200f);
        ObjectAnimator oaSetting = ObjectAnimator.ofFloat(
                mImageViewSetting, "translationX", -200f);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(1000);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(oaApp, oaLocation, oaMusic, oaCamera, oaSetting);
        set.start();
        mImageViewLocation.setVisibility(View.VISIBLE);
        mImageViewMusic.setVisibility(View.VISIBLE);
        mImageViewCamera.setVisibility(View.VISIBLE);
        mImageViewSetting.setVisibility(View.VISIBLE);

        mFlag = false;
    }

    private void closeAnimation() {
        ObjectAnimator oaApp = ObjectAnimator.ofFloat(
                mImageViewApp, "alpha", 0.5f, 1f);
        //移动X/Y是相对原始的坐标值的，所以这里是0，代表移动回去
        ObjectAnimator oaLocation = ObjectAnimator.ofFloat(
                mImageViewLocation, "translationY", 0);
        ObjectAnimator oaMusic = ObjectAnimator.ofFloat(
                mImageViewMusic, "translationX", 0);
        ObjectAnimator oaCamera = ObjectAnimator.ofFloat(
                mImageViewCamera, "translationY", 0);
        ObjectAnimator oaSetting = ObjectAnimator.ofFloat(
                mImageViewSetting, "translationX", 0);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(1000);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(oaApp, oaLocation, oaMusic, oaCamera, oaSetting);
        set.start();
        mImageViewLocation.setVisibility(View.GONE);
        mImageViewMusic.setVisibility(View.GONE);
        mImageViewCamera.setVisibility(View.GONE);
        mImageViewSetting.setVisibility(View.GONE);

        mFlag = true;
    }
}
