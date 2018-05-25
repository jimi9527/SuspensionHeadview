package com.example.suspensionheadview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivity";
    RecyclerView mReclerView;
    ReclerviewAdapter mReclerviewAdapter;
    LinearLayoutManager linearLayoutManager;
    LinearLayout  mLinearSusp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mLinearSusp = findViewById(R.id.linear_susp);
        mReclerView = findViewById(R.id.recyclerview);
        mReclerviewAdapter = new ReclerviewAdapter(this);
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
                Log.d(TAG,"onScrolled");
                getScollYDistance();
            }
        });

    }

    public void getScollYDistance(){
        int postion = linearLayoutManager.findFirstVisibleItemPosition();
        Log.d(TAG,"postion:"+postion);
        if(postion > 0){
            mLinearSusp.setVisibility(View.VISIBLE);
        }else {
            mLinearSusp.setVisibility(View.GONE);
        }
    }
}

