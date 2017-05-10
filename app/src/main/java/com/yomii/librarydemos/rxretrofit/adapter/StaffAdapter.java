package com.yomii.librarydemos.rxretrofit.adapter;

import android.view.ViewGroup;

import com.yomii.librarydemos.BR;
import com.yomii.librarydemos.R;
import com.yomii.librarydemos.base.BaseRecyclerAdapter;
import com.yomii.librarydemos.base.BaseRecyclerHolder;
import com.yomii.librarydemos.rxretrofit.bean.Movie.Staff;

/**
 * 人物适配器，用于Movie页面中的演员和导演列表
 *
 * Created by Yomii on 2017/5/10.
 */

public class StaffAdapter extends BaseRecyclerAdapter<Staff> {

    @Override
    public BaseRecyclerHolder<Staff> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BindingRecyclerHolder<>(parent, R.layout.movie_detail_recycler_staff, BR.staff);
    }
}
