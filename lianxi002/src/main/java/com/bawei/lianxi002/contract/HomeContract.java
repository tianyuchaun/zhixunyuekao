package com.bawei.lianxi002.contract;

import com.bawei.lianxi002.model.bean.FlowBean;
import com.bawei.lianxi002.model.bean.GsonBean;

public interface HomeContract {
    interface Iview{
        void onFlowSuccess(FlowBean flowBean);
        void onFlowFailure(Throwable throwable);

        void onGsonSuccess(GsonBean gsonBean);
        void onGsonFailure(Throwable throwable);
    }
    interface Ipresenter{
        void getFlowData(String fname);
        void getGsonData(String gname);
    }
    interface Imodel{
        void getFlowData(String fname,ImodelFlowCallBack imodelFlowCallBack);
        interface ImodelFlowCallBack{
            void onFlowSuccess(FlowBean flowBean);
            void onFlowFailure(Throwable throwable);
        }
        void getGsonData(String gname,ImodelGsonCallBack imodelGsonCallBack);
        interface ImodelGsonCallBack{
            void onGsonSuccess(GsonBean gsonBean);
            void onGsonFailure(Throwable throwable);
        }
    }
}
