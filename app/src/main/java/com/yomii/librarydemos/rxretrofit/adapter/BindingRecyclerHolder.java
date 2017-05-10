package com.yomii.librarydemos.rxretrofit.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;

import com.yomii.librarydemos.base.BaseRecyclerHolder;

/**
 * Created by Yomii on 2017/5/4.
 */

public class BindingRecyclerHolder<K> extends BaseRecyclerHolder<K> {


    private int brId;
    private ViewDataBinding bind;

    public BindingRecyclerHolder(ViewGroup parent, @LayoutRes int layoutRes, int brId) {
        super(parent, layoutRes);
        this.brId = brId;
    }

    @Override
    protected void setDataToView(K data, int position) {
        bind.setVariable(brId,data);
        bind.executePendingBindings();//立即刷新绑定数据的更改
    }

    @Override
    protected void initView(View itemView) {
        bind = DataBindingUtil.bind(itemView);
    }
}
