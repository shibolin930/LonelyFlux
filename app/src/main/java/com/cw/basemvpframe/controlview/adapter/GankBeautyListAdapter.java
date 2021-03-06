// (c)2016 Flipboard Inc, All Rights Reserved.

package com.cw.basemvpframe.controlview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cw.basemvpframe.R;
import com.cw.basemvpframe.model.GankBeauty;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GankBeautyListAdapter extends RecyclerView.Adapter {
    List<GankBeauty> images;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new DebounceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DebounceViewHolder debounceViewHolder = (DebounceViewHolder) holder;
        GankBeauty image = images.get(position);
        Glide.with(holder.itemView.getContext()).load(image.getImage_url()).into(debounceViewHolder.imageIv);
        debounceViewHolder.descriptionTv.setText(image.getDescription());
    }

    @Override
    public int getItemCount() {
        return images == null ? 0 : images.size();
    }

    public void setImages(List<GankBeauty> images) {
        this.images = images;
        notifyDataSetChanged();
    }

    static class DebounceViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.imageIv) ImageView imageIv;
        @Bind(R.id.descriptionTv) TextView descriptionTv;
        public DebounceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
