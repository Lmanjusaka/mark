package com.example.eyesmart.Activity;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class BaseActivity extends AppCompatActivity {
    private long time = System.currentTimeMillis();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
        }
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE);
    }
    public void onResume(){
        super.onResume();
    }
    public boolean dispatchTouchEvent(MotionEvent motionEvent){
        if (motionEvent.getAction() == 0){
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

}
