package com.example.android.androidanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class PropertyAnimationActivity extends AppCompatActivity
        implements View.OnClickListener {
    private static final String TAG = "PropertyAnimationActivi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        findViewById(R.id.btn_object_animator_translate).setOnClickListener(this);
        findViewById(R.id.btn_object_animator_rotation).setOnClickListener(this);
        findViewById(R.id.btn_object_animator_rotation_x).setOnClickListener(this);
        findViewById(R.id.btn_object_animator_scale_x).setOnClickListener(this);
        findViewById(R.id.btn_object_animator_x).setOnClickListener(this);
        findViewById(R.id.btn_object_animator_alpha).setOnClickListener(this);
        findViewById(R.id.btn_object_animator_property_value_holder).setOnClickListener(this);
        findViewById(R.id.btn_value_animator).setOnClickListener(this);
        findViewById(R.id.btn_animator_set).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_object_animator_translate:
                ObjectAnimator oa = ObjectAnimator.ofFloat(v, "translationX", //or "translationY"
                        new float[] {300, 400, 500, 0});
                oa.setDuration(3000);
                oa.start();
                break;
            case R.id.btn_object_animator_rotation:
                ObjectAnimator oar = ObjectAnimator.ofFloat(v, "rotation",
                        new float[] {60, 120, 180, 360});
                oar.setDuration(3000);
                oar.start();
                break;
            case R.id.btn_object_animator_rotation_x:
                ObjectAnimator oarx = ObjectAnimator.ofFloat(v, "rotationX", //or "rotationY"
                        new float[] {60, 120, 180, 360});
                oarx.setDuration(3000);
                oarx.start();
                break;
            case R.id.btn_object_animator_scale_x:
                ObjectAnimator oasx = ObjectAnimator.ofFloat(v, "scaleX", //or "scaleY"
                        new float[] {.8f, .6f, 0.4f});
                oasx.setDuration(3000);
                oasx.start();
                break;
            case R.id.btn_object_animator_x:
                ObjectAnimator oax = ObjectAnimator.ofFloat(v, "x", //or "y"
                        new float[] {100, 200, 300});
                oax.setDuration(3000);
                oax.start();
                break;
            case R.id.btn_object_animator_alpha:
                ObjectAnimator oaf = ObjectAnimator.ofFloat(v, "alpha",
                        new float[] {0.2f, 0.4f, 0.6f});
                oaf.setDuration(3000);
                oaf.start();
                break;
            case R.id.btn_object_animator_property_value_holder:
                PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("translationX", 300f);
                PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
                PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);

                ObjectAnimator.ofPropertyValuesHolder(v, pvh1, pvh2, pvh3)
                        .setDuration(3000).start();
                break;
            case R.id.btn_value_animator:
                ValueAnimator va = ValueAnimator.ofFloat(0, 100);
                va.setTarget(v);
                va.setDuration(3000);
                va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    int i = 0;
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Float value = (Float) animation.getAnimatedValue();
                        Log.d(TAG, "onAnimationUpdate: value=" + value + ",i=" + i);
                        i++;
                    }
                });
                va.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.d(TAG, "onAnimationStart: ");
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.d(TAG, "onAnimationEnd: ");
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        Log.d(TAG, "onAnimationCancel: ");
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        Log.d(TAG, "onAnimationRepeat: ");
                    }
                });
                va.start();
                break;
            case R.id.btn_animator_set:
                ObjectAnimator oa1 = ObjectAnimator.ofFloat(v, "translationX", 300f);
                ObjectAnimator oa2 = ObjectAnimator.ofFloat(v, "scaleX", 1f, 0, 1f);
                ObjectAnimator oa3 = ObjectAnimator.ofFloat(v, "scaleY", 1f, 0, 1f);
                AnimatorSet as = new AnimatorSet();
                as.setDuration(3000);
                // play all together
                //as.playTogether(oa1, oa2, oa3);

                // play sequentially with 3000 duration each
                //as.playSequentially(oa1, oa2, oa3);

                // oa1--> oa2 + oa3
                as.play(oa2).with(oa3).after(oa1);
                as.start();
                break;
            default:
                Log.e(TAG, "onClick: unknown id");
                break;
        }
    }
}
