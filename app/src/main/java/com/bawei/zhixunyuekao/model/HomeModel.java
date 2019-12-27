package com.bawei.zhixunyuekao.model;

import android.util.Log;

import com.bawei.zhixunyuekao.contract.HomeContract;
import com.bawei.zhixunyuekao.model.bean.FlowBean;
import com.bawei.zhixunyuekao.model.bean.GsonBean;
import com.bawei.zhixunyuekao.util.NetUtil;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HomeModel implements HomeContract.Imodel {



    @Override
    public void getJsonData(String name, final IgsonModelCallBck igsonModelCallBck) {
        try {
            String encode = URLEncoder.encode(name, "UTF-8");
            String httpUrl = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?page=1&count=30&keyword="+encode;
            NetUtil.getInstance().onGetJsonGget(httpUrl, new NetUtil.MyCallBack() {
                @Override
                public void onGetJson(String json) {
                    GsonBean gsonBean = new Gson().fromJson(json, GsonBean.class);
                    igsonModelCallBck.onJsonSuccess(gsonBean);
                }

                @Override
                public void onError(Throwable throwable) {
                    igsonModelCallBck.onJsonFailure(throwable);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getFlowData(String name, final IflowModelCallBck iflowModelCallBck) {
        String encode = null;
        try {
            encode = URLEncoder.encode(name, "UTF-8");
            String httpUrl = "http://blog.zhaoliang5156.cn/baweiapi/"+encode;
            NetUtil.getInstance().onGetJsonGget(httpUrl, new NetUtil.MyCallBack() {
                @Override
                public void onGetJson(String json) {
                    Log.d("xx", json);
                    FlowBean flowBean = new Gson().fromJson(json, FlowBean.class);

                    iflowModelCallBck.onFlwoSuccess(flowBean);
                }

                @Override
                public void onError(Throwable throwable) {
                    iflowModelCallBck.onFlwoFailure(throwable);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
