package com.bawei.lianxi001.presenter;

import com.bawei.lianxi001.base.BasePresenter;
import com.bawei.lianxi001.contract.HomeContract;
import com.bawei.lianxi001.model.HomeModel;
import com.bawei.lianxi001.model.bean.FlowBean;
import com.bawei.lianxi001.model.bean.GsonBean;


public class HomePresenter extends BasePresenter<HomeContract.Iview> implements HomeContract.Ipresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getJsonData(String name) {
        homeModel.getJsonData(name, new HomeContract.Imodel.IgsonModelCallBck() {
            @Override
            public void onJsonSuccess(GsonBean gsonBean) {
                view.onJsonSuccess(gsonBean);
            }

            @Override
            public void onJsonFailure(Throwable throwable) {
                view.onJsonFailure(throwable);
            }
        });
    }

    @Override
    public void getFlowData(String name) {
        homeModel.getFlowData(name, new HomeContract.Imodel.IflowModelCallBck() {
            @Override
            public void onFlwoSuccess(FlowBean flowBean) {
                view.onFlwoSuccess(flowBean);
            }

            @Override
            public void onFlwoFailure(Throwable throwable) {
                view.onFlwoFailure(throwable);
            }
        });
    }
}
