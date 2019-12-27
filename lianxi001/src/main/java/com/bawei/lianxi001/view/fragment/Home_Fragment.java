package com.bawei.lianxi001.view.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.bawei.lianxi001.FlowLayout;
import com.bawei.lianxi001.base.BaseFragment;
import com.bawei.lianxi001.contract.HomeContract;
import com.bawei.lianxi001.model.bean.FlowBean;
import com.bawei.lianxi001.model.bean.GsonBean;
import com.bawei.lianxi001.presenter.HomePresenter;
import com.bawei.lianxi001.view.activity.Main2Activity;
import com.bawei.lianxi001.view.adapter.RcAdapter;
import com.bawei.zhixunyuekao.R;


import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends BaseFragment<HomePresenter> implements HomeContract.Iview {

    private FlowLayout fl;
    private RecyclerView rc;
    private EditText et;
    private Button bt;

    @Override
    protected void initView(View inflate) {
        fl = inflate.findViewById(R.id.fl);
        rc = inflate.findViewById(R.id.rc);
        et = inflate.findViewById(R.id.et);
        bt = inflate.findViewById(R.id.bt);
        fl.setOnTagItimClick(new FlowLayout.OnTagItimClick() {
            @Override
            public void onClick(String tag) {
                Toast.makeText(getActivity(), tag, Toast.LENGTH_SHORT).show();
                et.setText(tag);
                pPresenter.getJsonData(tag);
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = et.getText().toString();
                if (s.equals("")) {
                    Toast.makeText(getActivity(), "搜索框为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                fl.addTag(s);
                pPresenter.getJsonData(s);
            }
        });

    }

    @Override
    protected HomePresenter Fpresenter() {
        return new HomePresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home_;
    }

    @Override
    protected void initData() {
        pPresenter.getFlowData("手机");
        pPresenter.getJsonData("板鞋");
    }

    @Override
    public void onJsonSuccess(GsonBean gsonBean) {
        List<GsonBean.ResultBean> list = gsonBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rc.setLayoutManager(linearLayoutManager);
        RcAdapter rcAdapter = new RcAdapter(list);
        rc.setAdapter(rcAdapter);
        rcAdapter.setOnClickLister(new RcAdapter.OnClickLister() {
            @Override
            public void OnClick(int postion) {
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                getActivity().startActivity(intent);
            }
        });

    }

    @Override
    public void onJsonFailure(Throwable throwable) {
    }

    @Override
    public void onFlwoSuccess(FlowBean flowBean) {
        List<String> tags = flowBean.getTags();
        for (int i = 0; i < tags.size(); i++) {
            String s = tags.get(i);
            fl.addTag(s);
        }
    }

    @Override
    public void onFlwoFailure(Throwable throwable) {

    }
}
