package com.yomii.librarydemos;

import android.content.Context;
import android.content.Intent;

/**
 * 页面跳转辅助类
 * Created by Yomii on 2017/3/17.
 */

public class PageUtils {

    public static void imageFuncActivity(Context context){
        context.startActivity(new Intent(context, ImageFuncActivity.class));
    }
}
