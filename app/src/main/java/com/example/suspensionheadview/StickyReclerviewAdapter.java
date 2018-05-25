package com.example.suspensionheadview;

import android.content.Context;
import android.print.PrinterId;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * author: daxiong9527
 * mail : 15570350453@163.com
 */
public class StickyReclerviewAdapter extends RecyclerView.Adapter {

    private final static String TAG = "Sticky";
    private final static int TYPE_TITLE = 1;
    private final static int TYPE_ITEM = 2;
    private Context mContext;
    private List<Sticky> lists = new ArrayList<>();
    public StickyReclerviewAdapter(Context mContext,List<Sticky> lists) {
        this.mContext = mContext;
        this.lists = lists;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_TITLE){
            View titleview = LayoutInflater.from(mContext).inflate(R.layout.view_title,parent,false);
            return new TitleViewHolder(titleview);
        }else {
            View contentview = LayoutInflater.from(mContext).inflate(R.layout.view_item,parent,false);
            return new ContentViewHolder(contentview);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof TitleViewHolder){
            TitleViewHolder titleViewHolder = (TitleViewHolder) holder;
            titleViewHolder.mTitle.setText(lists.get(position).getTitle());
        }else {
            ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
            contentViewHolder.mContent.setText(lists.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(lists.get(position).getType() == 1){
            return TYPE_TITLE;
        }else {
            return TYPE_ITEM;
        }
    }

    class TitleViewHolder extends RecyclerView.ViewHolder{
        TextView mTitle;
        public TitleViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
        }
    }
    class ContentViewHolder extends RecyclerView.ViewHolder{
        TextView mContent;
        public ContentViewHolder(View itemView) {
            super(itemView);
            mContent = itemView.findViewById(R.id.content);
        }
    }

}
