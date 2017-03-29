package com.yomii.librarydemos;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * DataBinding库的自定义属性方法管理
 * Created by Yomii on 2017/3/29.
 */

public class DataBindingMethods {

    @BindingAdapter(value = {"android:src", "placeHolder"}, requireAll = false)
    public static void loadUrlImage(ImageView view, String url, int placeHolder) {
        Glide.with(view.getContext()).load(url).placeholder(placeHolder).into(view);
    }
}
