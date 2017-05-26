package com.redcarpet.in.retrofittask.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.redcarpet.in.retrofittask.R;
import com.redcarpet.in.retrofittask.activity.MainActivity;

/**
 * Created by simran on 5/25/2017.
 */

public class SplashActivity extends AppCompatActivity {
    TextView redcarpet;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        redcarpet=(TextView)findViewById(R.id.redcarpet);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/CarnevaleeFreakshow.ttf");
        redcarpet.setTypeface(type);
        AlphaAnimation fadeOut = new AlphaAnimation(0.0f, 1.0f);
        AlphaAnimation fadeIn = new AlphaAnimation(1.0f, 0.0f);
        redcarpet.startAnimation(fadeIn);
        redcarpet.startAnimation(fadeOut);
        fadeIn.setDuration(500);
        fadeIn.setFillAfter(true);
        fadeOut.setDuration(1000);
        fadeOut.setFillAfter(true);
        fadeOut.setStartOffset(500 + fadeIn.getStartOffset());
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
