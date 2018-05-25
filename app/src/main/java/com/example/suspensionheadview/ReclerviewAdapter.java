package com.example.suspensionheadview;

import android.content.Context;
import android.print.PrinterId;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author: daxiong9527
 * mail : 15570350453@163.com
 */
public class ReclerviewAdapter  extends RecyclerView.Adapter {

    private Context mContext;
    private final static int TYPE_HEAD = 1;
    private final static int TYPE_SUSP = 2;
    private final static int TYPE_ITEM = 3;

    public ReclerviewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEAD) {
            View headview = LayoutInflater.from(mContext).inflate(R.layout.view_head, parent, false);
            return new HeadViewHolder(headview);
        } else if (viewType == TYPE_SUSP) {
            View suspview = LayoutInflater.from(mContext).inflate(R.layout.view_suspension, parent, false);
            return new SuspensionViewHolder(suspview);
        } else {
            View itemview = LayoutInflater.from(mContext).inflate(R.layout.view_item, parent, false);
            return new ItemViewHolder(itemview);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEAD;
        } else if (position == 1) {
            return TYPE_SUSP;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    class HeadViewHolder extends RecyclerView.ViewHolder {

        public HeadViewHolder(View itemView) {
            super(itemView);
        }
    }

    class SuspensionViewHolder extends RecyclerView.ViewHolder {

        public SuspensionViewHolder(View itemView) {
            super(itemView);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }

}

