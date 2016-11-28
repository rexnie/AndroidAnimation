package com.example.android.androidanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class ViewAnimationTestActivity extends AppCompatActivity
        implements View.OnClickListener {
    private static final String TAG = "ViewAnimationTestActivi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation_test);
        findViewById(R.id.btn_alpha_animation).setOnClickListener(this);
        findViewById(R.id.btn_rotate_animation).setOnClickListener(this);
        findViewById(R.id.btn_rotate_animation_rel).setOnClickListener(this);
        findViewById(R.id.btn_translate_animation).setOnClickListener(this);
        findViewById(R.id.btn_scale_animation).setOnClickListener(this);
        findViewById(R.id.btn_scale_animation_rel).setOnClickListener(this);
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
                /*相对绝对位置（100，100）旋转*/
                RotateAnimation ra = new RotateAnimation(0, 360, 100, 100);
                ra.setDuration(3000);
                v.startAnimation(ra);
                break;
            case R.id.btn_rotate_animation_rel:
                /*相对自己的70%的位置旋转*/
                RotateAnimation ra2 = new RotateAnimation(0, 360,
                        RotateAnimation.RELATIVE_TO_SELF, 0.7f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.7f);
                ra2.setDuration(3000);
                v.startAnimation(ra2);
                break;
            case R.id.btn_translate_animation:
                TranslateAnimation ta = new TranslateAnimation(0, 200, 0, 300);
                ta.setDuration(3000);
                v.startAnimation(ta);
                break;
            case R.id.btn_scale_animation:
                ScaleAnimation sa = new ScaleAnimation(0, 2, 0, 2);
                sa.setDuration(3000);
                v.startAnimation(sa);
                break;
            case R.id.btn_scale_animation_rel:
                ScaleAnimation sa2 = new ScaleAnimation(0, 1, 0, 1,
                        Animation.RELATIVE_TO_SELF, 0.3f,
                        Animation.RELATIVE_TO_SELF, 0.3f);
                sa2.setDuration(3000);
                v.startAnimation(sa2);
                break;
            default:
                Log.e(TAG, "onClick: ");
                break;
        }
    }
}
