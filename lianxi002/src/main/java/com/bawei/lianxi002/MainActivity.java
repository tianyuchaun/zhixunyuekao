package com.bawei.lianxi002;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.lianxi002.base.BaseActivity;
import com.bawei.lianxi002.contract.HomeContract;
import com.bawei.lianxi002.model.bean.FlowBean;
import com.bawei.lianxi002.model.bean.GsonBean;
import com.bawei.lianxi002.presenter.HomePresenter;
import com.bawei.lianxi002.view.adapter.RcAdapter;

import java.util.List;

public class MainActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {


    private FlowLayout fl;
    private RecyclerView rc;

    @Override
    protected void initData() {
        mPresenter.getFlowData("手机");
        mPresenter.getGsonData("板鞋");
    }

    @Override
    protected void initView() {
        fl = findViewById(R.id.fl);
        rc = findViewById(R.id.rc);
        fl.setOnFlowItmeClick(new FlowLayout.OnFlowItmeClick() {
            @Override            public void onClick(String tag) {

                Toast.makeText(MainActivity.this, "我点击了"+tag, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onFlowSuccess(FlowBean flowBean) {
        List<String> tags = flowBean.getTags();
        for (int i = 0; i < tags.size(); i++) {
            String s = tags.get(i);
            Log.d("xxx", s);
            fl.addTag(s);
        }
    }

    @Override
    public void onFlowFailure(Throwable throwable) {

    }

    @Override
    public void onGsonSuccess(GsonBean gsonBean) {

        List<GsonBean.ResultBean> list = gsonBean.getResult();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        rc.setLayoutManager(gridLayoutManager);

        RcAdapter rcAdapter = new RcAdapter(list);
        rc.setAdapter(rcAdapter);
    }

    @Override
    public void onGsonFailure(Throwable throwable) {

    }
}
