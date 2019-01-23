package com.zxn.nestsrcoll.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zxn.nestsrcoll.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zxn on 2019/1/23.
 */
public class SupportPoorAdapter extends BaseQuickAdapter<String, SupportPoorAdapter.ViewHolder> {

    public SupportPoorAdapter() {
        super(R.layout.item_support_poor);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(ViewHolder helper, String item) {
        helper.tvSupportTitle.setText(item);
    }

    static class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_support_title)
        TextView tvSupportTitle;
        @BindView(R.id.iv_support_image)
        ImageView ivSupportImage;
        @BindView(R.id.tv_support_source)
        TextView tvSupportSource;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
