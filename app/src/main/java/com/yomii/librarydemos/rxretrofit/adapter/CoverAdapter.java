package com.yomii.librarydemos.rxretrofit.adapter;

import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yomii.librarydemos.BaseRecyclerAdapter;
import com.yomii.librarydemos.BaseRecyclerHolder;
import com.yomii.librarydemos.PageUtils;
import com.yomii.librarydemos.R;
import com.yomii.librarydemos.rxretrofit.bean.Cover;

/**
 * Douban页面RecyclerView适配器
 * Created by Yomii on 2017/3/27.
 */

public class CoverAdapter extends BaseRecyclerAdapter<Cover> {

    @Override
    public BaseRecyclerHolder<Cover> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CoverHolder(parent, R.layout.douban_recycler);
    }

    private class CoverHolder extends BaseRecyclerHolder<Cover> {


        private ImageView coverView;
        private TextView titleView;
        private RatingBar ratingBar;

        CoverHolder(ViewGroup parent, @LayoutRes int layoutRes) {
            super(parent, layoutRes);
        }

        @Override
        protected void setDataToView(Cover data, int position) {
            Glide.with(coverView.getContext())
                    .load(data.getCoverUrl())
                    .into(coverView);

            titleView.setText(data.getTitle());

            double percent = data.getRatingValue();
            float value = (float) (percent * ratingBar.getNumStars());
            ratingBar.setRating(value);
        }

        @Override
        protected void initView(View itemView) {
            coverView = (ImageView) itemView.findViewById(R.id.cover_image);
            titleView = (TextView) itemView.findViewById(R.id.cover_title);
            ratingBar = (RatingBar) itemView.findViewById(R.id.cover_rating);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PageUtils.doubanDetailActivity(v.getContext(), data);
                }
            });
        }
    }
}
