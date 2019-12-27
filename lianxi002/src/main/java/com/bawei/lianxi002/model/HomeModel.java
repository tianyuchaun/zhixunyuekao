package com.bawei.lianxi002.model;

import com.bawei.lianxi002.contract.HomeContract;
import com.bawei.lianxi002.model.bean.FlowBean;
import com.bawei.lianxi002.model.bean.GsonBean;
import com.bawei.lianxi002.util.NetUtil;
import com.google.gson.Gson;

import java.net.URLEncoder;

public class HomeModel implements HomeContract.Imodel {
    @Override
    public void getFlowData(String fname, final ImodelFlowCallBack imodelFlowCallBack) {
        try {
            String encode = URLEncoder.encode(fname, "UTF-8");
            String httpUrl = "http://blog.zhaoliang5156.cn/baweiapi/"+encode;
            NetUtil.getInstance().onGetJsonGet(httpUrl, new NetUtil.MyCallBack() {
                @Override
                public void onGetJson(String json) {
                    FlowBean flowBean = new Gson().fromJson(json, FlowBean.class);
                    imodelFlowCallBack.onFlowSuccess(flowBean);
                }

                @Override
                public void onError(Throwable throwable) {
                    imodelFlowCallBack.onFlowFailure(throwable);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getGsonData(String gname, final ImodelGsonCallBack imodelGsonCallBack) {
        try {
            String encode = URLEncoder.encode(gname, "UTF-8");
            String httpUrl = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?page=1&count=30&keyword="+encode;
            NetUtil.getInstance().onGetJsonGet(httpUrl, new NetUtil.MyCallBack() {
                @Override
                public void onGetJson(String json) {
                    GsonBean gsonBean = new Gson().fromJson(json, GsonBean.class);
                    imodelGsonCallBack.onGsonSuccess(gsonBean);
                }

                @Override
                public void onError(Throwable throwable) {
                    imodelGsonCallBack.onGsonFailure(throwable);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
