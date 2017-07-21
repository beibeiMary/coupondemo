package com.example.zhangshuyang01.coupondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.RelativeLayout;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private XRecyclerView xRecyclerView;
    private RelativeLayout rl_empty;
    private int page=1,total_page,isOnRefresh=1;
    private ArrayList<Map<String,String>> mapList ;
    private MyCouponAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xRecyclerView = (XRecyclerView) findViewById(R.id.xrv_list);
        rl_empty = (RelativeLayout) findViewById(R.id.rl_empty);

        init();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        xRecyclerView.setEmptyView(rl_empty);
        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                isOnRefresh=2;

            }

            @Override
            public void onLoadMore() {
                if (total_page-page>0){
                    page++;

                }else {
                    xRecyclerView.loadMoreComplete();
                }
            }
        });

        mAdapter = new MyCouponAdapter(mapList);
        xRecyclerView.setAdapter(mAdapter);
    }
    public void init() {
        mapList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Map<String, String> maps = new HashMap<>();
            maps.put("number", ""+i);
            maps.put("unit", ""+i);
            maps.put("description", "描述"+i);
            maps.put("failtrue_time", "2018/"+i);
            mapList.add(maps);
        }
    }
}
