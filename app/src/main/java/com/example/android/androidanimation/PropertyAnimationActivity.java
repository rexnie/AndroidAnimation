package com.example.android.androidanimation;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_object_animator_translate:
                ObjectAnimator oa = ObjectAnimator.ofFloat(v, "translationX",
                        new float[] {300, 400, 500, 0}); //translationY
                oa.setDuration(3000);
                oa.start();
                break;
            default:
                Log.e(TAG, "onClick: unknown id");
                break;
        }
    }
}
