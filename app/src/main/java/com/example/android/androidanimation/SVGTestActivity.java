package com.example.android.androidanimation;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SVGTestActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg_test);

        findViewById(R.id.iv_two_path).setOnClickListener(this);
        findViewById(R.id.iv_sun_earth_moon).setOnClickListener(this);
        findViewById(R.id.iv_search_bar).setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_two_path:
            case R.id.iv_sun_earth_moon:
            case R.id.iv_search_bar:
                Drawable d = ((ImageView) v).getDrawable();
                if (d instanceof Animatable) {
                    ((Animatable) d).start();
                }
                break;
        }
    }
}
