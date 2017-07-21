package com.example.zhangshuyang01.coupondemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by zhangshuyang01 on 2017/7/20 0020.
 */

public class MyCouponAdapter extends RecyclerView.Adapter<MyCouponAdapter.ViewHolder>{
    public ArrayList<Map<String,String>> datas = null;

    public MyCouponAdapter(ArrayList<Map<String,String>> datas) {
        this.datas = datas;
    }

    @Override
    public MyCouponAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coupon, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyCouponAdapter.ViewHolder holder, int position) {
        holder.tv_use_time1.setText(datas.get(position).get("number")+"");
        holder.tv_unit.setText(datas.get(position).get("unit")+"");
        holder.tv_coupon_name.setText(datas.get(position).get("description")+"");
        holder.tv_coupon_time.setText("有效期至" + datas.get(position).get("failtrue_time")+"");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_use_time1, tv_unit, tv_coupon_name, tv_coupon_time;

        public ViewHolder(View view) {
            super(view);
            tv_use_time1 = (TextView) view.findViewById(R.id.tv_use_time1);
            tv_unit = (TextView) view.findViewById(R.id.tv_unit);
            tv_coupon_name = (TextView) view.findViewById(R.id.tv_coupon_name);
            tv_coupon_time = (TextView) view.findViewById(R.id.tv_coupon_time);
        }
    }
}
