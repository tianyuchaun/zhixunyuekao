package com.bawei.lianxi002.presenter;

import com.bawei.lianxi002.base.BasePresenter;
import com.bawei.lianxi002.contract.HomeContract;
import com.bawei.lianxi002.model.HomeModel;
import com.bawei.lianxi002.model.bean.FlowBean;
import com.bawei.lianxi002.model.bean.GsonBean;

public class HomePresenter extends BasePresenter<HomeContract.Iview> implements HomeContract.Ipresenter {


    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getFlowData(String fname) {
        homeModel.getFlowData(fname, new HomeContract.Imodel.ImodelFlowCallBack() {
            @Override
            public void onFlowSuccess(FlowBean flowBean) {
                view.onFlowSuccess(flowBean);
            }

            @Override
            public void onFlowFailure(Throwable throwable) {
                view.onFlowFailure(throwable);
            }
        });
    }

    @Override
    public void getGsonData(String gname) {
        homeModel.getGsonData(gname, new HomeContract.Imodel.ImodelGsonCallBack() {
            @Override
            public void onGsonSuccess(GsonBean gsonBean) {
                view.onGsonSuccess(gsonBean);
            }

            @Override
            public void onGsonFailure(Throwable throwable) {
                view.onGsonFailure(throwable);
            }
        });
    }
}
