package com.example.android.androidanimation;

import android.content.Intent;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.Transformation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_view_animation).setOnClickListener(this);
        findViewById(R.id.btn_property_animation).setOnClickListener(this);
        findViewById(R.id.btn_customer_animation).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_view_animation:
                startActivity(new Intent(this, ViewAnimationTestActivity.class));
                break;

            case R.id.btn_property_animation:
                startActivity(new Intent(this, PropertyAnimationActivity.class));
                break;
            case R.id.btn_customer_animation:
                CustomerAnimation ca = new CustomerAnimation();
                v.startAnimation(ca);
                break;
            default:
                Log.e(TAG, "onClick: unknown id");
                break;
        }
    }
}

class CustomerAnimation extends Animation {
    private int mCenterWidth;
    private int mCenterHeight;
    private int mRotateX;
    private Camera mCamera;

    public CustomerAnimation() {
        super();
        mCamera = new Camera();
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        setDuration(2000); //默认时长
        setFillAfter(true); // 动画结束后保留状态
        setInterpolator(new BounceInterpolator()); // 设置默认插值器
        mCenterWidth = width / 2;
        mCenterHeight = height / 2;
        mRotateX = 360; // in degree
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final Matrix matrix = t.getMatrix();
        mCamera.save();

        // 设置Camera绕X轴旋转角度
        mCamera.rotateX(mRotateX * interpolatedTime);

        //拷贝旋转变换到 matrix
        mCamera.getMatrix(matrix);
        mCamera.restore();

        // 改变旋转中心
        matrix.preTranslate(mCenterWidth, mCenterHeight);
        matrix.postTranslate(-mCenterWidth, -mCenterHeight);
    }
}