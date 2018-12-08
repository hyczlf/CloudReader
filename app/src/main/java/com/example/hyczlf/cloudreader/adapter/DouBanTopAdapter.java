package com.example.hyczlf.cloudreader.adapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;

import com.example.hyczlf.cloudreader.R;
import com.example.hyczlf.cloudreader.base.baseadapter.BaseRecyclerViewAdapter;
import com.example.hyczlf.cloudreader.base.baseadapter.BaseRecyclerViewHolder;
import com.example.hyczlf.cloudreader.bean.moviechild.SubjectsBean;
import com.example.hyczlf.cloudreader.databinding.ItemDoubanTopBinding;
import com.example.hyczlf.cloudreader.ui.movie.OneMovieDetailActivity;
import com.example.hyczlf.cloudreader.utils.DensityUtil;
import com.example.hyczlf.cloudreader.utils.DialogBuild;
import com.example.hyczlf.cloudreader.utils.PerfectClickListener;

/**
 * Created by hyczlf on 2016/12/10.
 */

public class DouBanTopAdapter extends BaseRecyclerViewAdapter<SubjectsBean> {

    private Activity activity;
    private int width;

    public DouBanTopAdapter(Activity activity) {
        this.activity = activity;
        int px = DensityUtil.dip2px(36);
        width = (DensityUtil.getDisplayWidth() - px) / 3;
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent, R.layout.item_douban_top);
    }

    class ViewHolder extends BaseRecyclerViewHolder<SubjectsBean, ItemDoubanTopBinding> {

        ViewHolder(ViewGroup parent, int layout) {
            super(parent, layout);
        }

        @Override
        public void onBindViewHolder(final SubjectsBean bean, final int position) {
            binding.setBean(bean);
            /**
             * 当数据改变时，binding会在下一帧去改变数据，如果我们需要立即改变，就去调用executePendingBindings方法。
             */
            DensityUtil.formatHeight(binding.ivTopPhoto, width, 0.758f, 1);
            binding.executePendingBindings();
            binding.cvTopMovie.setOnClickListener(new PerfectClickListener() {
                @Override
                protected void onNoDoubleClick(View v) {
                    OneMovieDetailActivity.start(activity, bean, binding.ivTopPhoto);
                }
            });
        }
    }
}
