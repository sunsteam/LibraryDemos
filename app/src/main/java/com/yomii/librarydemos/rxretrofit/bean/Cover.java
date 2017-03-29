package com.yomii.librarydemos.rxretrofit.bean;

import android.os.Parcelable;

/**
 * 有封面的物品(获取封面图片网址)
 * Created by Yomii on 2017/3/27.
 */

public interface Cover extends Parcelable {

    String getCoverUrl();

    /**
     * 平均分/总分, 比如 7.5/10 = 0.75
     * @return 星级的比率
     */
    float getRatingValue();

    String getTitle();
}
