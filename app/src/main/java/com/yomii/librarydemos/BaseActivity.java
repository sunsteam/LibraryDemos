package com.yomii.librarydemos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Yomii on 2017/3/18.
 */

public abstract class BaseActivity extends AppCompatActivity {
    final String TAG = getClass().getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onInitVariable();
        onInitView();
        onInitData();
    }

    protected void onInitVariable() {

    }

    protected abstract void onInitView();

    protected abstract void onInitData();
}
