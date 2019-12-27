package com.bawei.lianxi002.view.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lianxi002.R;
import com.bawei.lianxi002.model.bean.GsonBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RcAdapter extends RecyclerView.Adapter<RcAdapter.Aaa> {
    private List<GsonBean.ResultBean> list;

    public RcAdapter(List<GsonBean.ResultBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public Aaa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.itme, null);
        return new Aaa(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Aaa holder, int position) {
        holder.tvv1.setText(list.get(position).getCommodityName());
        holder.tvv2.setText(list.get(position).getCommodityId()+"");
        Log.d("xx",list.get(position).getCommodityName());

        Glide.with(holder.imageView).load(list.get(position).getMasterPic())
                .error(R.drawable.ic_launcher_background)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Aaa extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvv1,tvv2;
        public Aaa(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.im);
            tvv1 = itemView.findViewById(R.id.tv1);
            tvv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
