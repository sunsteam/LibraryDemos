package com.yomii.librarydemos.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Yomii on 2017/3/18.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected final String TAG = getClass().getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onInitVariableOrFlag();
        onInitView();
        onInitData();
    }

    protected void onInitVariableOrFlag() {

    }

    protected abstract void onInitView();

    protected abstract void onInitData();

    protected void setLayoutFullScreen(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    public void moveBack(View v){
        onBackPressed();
    }
}
