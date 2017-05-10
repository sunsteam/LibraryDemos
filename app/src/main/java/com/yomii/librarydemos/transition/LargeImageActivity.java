package com.yomii.librarydemos.transition;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yomii.librarydemos.R;
import com.yomii.librarydemos.base.BaseActivity;

/**
 * 全屏展示图片
 * Created by Yomii on 2017/5/10.
 */

public class LargeImageActivity extends BaseActivity {

    private ImageView imageView;

    @Override
    protected void onInitView() {
        setLayoutFullScreen();
        getWindow().setBackgroundDrawableResource(R.color.black);
        setContentView(R.layout.large_image_activity);
        imageView = (ImageView) findViewById(R.id.large_cover);

    }

    @Override
    protected void onInitData() {
        String url = getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(url))
            Glide.with(this).load(url).placeholder(R.drawable.common_placeholder).into(imageView);
    }

    public static void shareImageToHere(String imageUrl, Activity from, View imageView){

        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                from, imageView, from.getString(R.string.transition_cover));

        Intent intent = new Intent(from, LargeImageActivity.class);
        intent.putExtra("url", imageUrl);
        from.startActivity(intent,activityOptionsCompat.toBundle());
    }
}
