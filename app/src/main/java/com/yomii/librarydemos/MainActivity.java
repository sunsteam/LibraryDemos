package com.yomii.librarydemos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_image_selector,R.id.button_rx_retrofit})
    void toFunction(View v){
        switch (v.getId()){
            case R.id.button_image_selector:
                PageUtils.imageFuncActivity(this);
                break;
            case R.id.button_rx_retrofit:
                PageUtils.RxRetrofitActivity(this);
                break;
        }

    }
}
