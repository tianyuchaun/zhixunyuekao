package com.bawei.lianxi001.contract;

import com.bawei.lianxi001.model.bean.FlowBean;
import com.bawei.lianxi001.model.bean.GsonBean;

public interface HomeContract {
    interface Iview {
        void onJsonSuccess(GsonBean gsonBean);

        void onJsonFailure(Throwable throwable);

        void onFlwoSuccess(FlowBean flowBean);

        void onFlwoFailure(Throwable throwable);
    }

    interface Ipresenter {
        void getJsonData(String name);

        void getFlowData(String name);
    }

    interface Imodel {
        void getJsonData(String name, IgsonModelCallBck igsonModelCallBck);

        interface IgsonModelCallBck {
            void onJsonSuccess(GsonBean gsonBean);

            void onJsonFailure(Throwable throwable);
        }

        void getFlowData(String name, IflowModelCallBck iflowModelCallBck);

        interface IflowModelCallBck {
            void onFlwoSuccess(FlowBean flowBean);

            void onFlwoFailure(Throwable throwable);
        }
    }
}
