package com.example.suspensionheadview;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * author: daxiong9527
 * mail : 15570350453@163.com
 */
public class StickyActivity extends Activity {

    final static String TAG = "MainActivity";
    RecyclerView mReclerView;
    StickyReclerviewAdapter mReclerviewAdapter;
    LinearLayoutManager linearLayoutManager;
    LinearLayout mLinearSusp;
    List<Sticky> lists = new ArrayList<>();
    TextView mSticky;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setData();
        initView();

    }

    private void initView() {
        mSticky = findViewById(R.id.sticky);
        mLinearSusp = findViewById(R.id.linear_susp);
        mReclerView = findViewById(R.id.recyclerview);
        mReclerviewAdapter = new StickyReclerviewAdapter(this, lists);
        linearLayoutManager = new LinearLayoutManager(this);
        mReclerView.setLayoutManager(linearLayoutManager);
        mReclerView.setAdapter(mReclerviewAdapter);

        mReclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                getScollYDistance();
            }
        });

    }

    void setData() {
        for (int j = 0; j < 5; j++) {
            Sticky sticky = new Sticky();
            sticky.setType(1);
            sticky.setTitle("type" + j);
            lists.add(sticky);
            for (int i = 0; i < 4; i++) {
                Sticky substicky = new Sticky();
                substicky.setType(0);
                substicky.setTitle("sub" + i);
                lists.add(substicky);
            }
        }
    }

    public void getScollYDistance() {
        int postion = linearLayoutManager.findFirstVisibleItemPosition();
        Log.d(TAG, "postion:" + postion);
        if (lists.get(postion).getType() == 1) {
            mLinearSusp.setVisibility(View.VISIBLE);
            mSticky.setText(lists.get(postion).getTitle());
        }
    }

}
