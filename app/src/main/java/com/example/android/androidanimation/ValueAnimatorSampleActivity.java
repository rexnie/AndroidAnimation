package com.example.android.androidanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

public class ValueAnimatorSampleActivity extends AppCompatActivity implements View.OnClickListener {
    private int mllHiddenMeasuredHeight;
    private LinearLayout mllHidden;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animtor_sample);
        mllHidden = (LinearLayout) findViewById(R.id.ll_hidden);

        ViewGroup.LayoutParams lp = mllHidden.getLayoutParams();
        mllHiddenMeasuredHeight = (int)(lp.height + 0.5);

        findViewById(R.id.tv_timer).setOnClickListener(this);
        findViewById(R.id.ll_click).setOnClickListener(this);
    }

    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.tv_timer:
                ValueAnimator va = ValueAnimator.ofFloat(0, 100);
                va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        ((TextView) v).setText(
                                String.format(Locale.CHINESE, "$ %3.0f",
                                        animation.getAnimatedValue()));
                    }
                });

                va.setDuration(3000);
                va.start();
                break;
            case R.id.ll_click:
                if (mllHidden.getVisibility() == View.GONE) {
                    openAnimation(mllHidden);
                } else {
                    closeAnimation(mllHidden);
                }
                break;
        }

    }

    private void openAnimation(LinearLayout llHidden) {
        llHidden.setVisibility(View.VISIBLE);
        ValueAnimator va = createDropAnimator(llHidden, 0, mllHiddenMeasuredHeight);
        va.start();
    }

    private void closeAnimation(final LinearLayout llHidden) {
        int origHeight = llHidden.getHeight();
        ValueAnimator va = createDropAnimator(llHidden, origHeight, 0);
        va.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                llHidden.setVisibility(View.GONE);
            }
        });
        va.start();
    }

    private ValueAnimator createDropAnimator(final View v, int start, int end) {
        final ValueAnimator va = ValueAnimator.ofInt(start, end);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                ViewGroup.LayoutParams lp = v.getLayoutParams();
                lp.height = value;
                v.setLayoutParams(lp);
            }
        });
        return va;
    }
}
