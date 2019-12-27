package com.bawei.zhixunyuekao.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bawei.zhixunyuekao.R;
import com.bawei.zhixunyuekao.model.bean.GsonBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RcAdapter extends RecyclerView.Adapter<RcAdapter.MyViewHoder> {


    private List<GsonBean.ResultBean> list;

    public RcAdapter(List<GsonBean.ResultBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.itme, null);

        return new MyViewHoder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoder holder, final int position) {
        holder.textView1.setText(list.get(position).getCommodityName());
        holder.textView2.setText(list.get(position).getPrice()+"");
        Glide.with(holder.imageView).load(list.get(position).getMasterPic())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickLister != null) {
                    onClickLister.OnClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHoder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1,textView2;
        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
            textView1 = itemView.findViewById(R.id.tv1);
            textView2 = itemView.findViewById(R.id.tv2);

        }
    }
    OnClickLister onClickLister;

    public void setOnClickLister(OnClickLister onClickLister) {
        this.onClickLister = onClickLister;
    }

    public interface OnClickLister{
        void OnClick(int postion);
    }

}
