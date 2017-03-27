package com.yomii.librarydemos.rxretrofit.bean;

import android.os.Parcelable;

/**
 * 有封面的物品(获取封面图片网址)
 * Created by Yomii on 2017/3/27.
 */

public interface Cover extends Parcelable {

    String getCoverUrl();

    double getRatingValue();

    String getTitle();
}
