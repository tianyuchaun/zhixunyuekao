package com.bawei.zhixunyuekao.contract;

import com.bawei.zhixunyuekao.model.bean.FlowBean;
import com.bawei.zhixunyuekao.model.bean.GsonBean;

public interface HomeContract {
    interface Iview{
        //json 数据的成功失败
        void onJsonSuccess(GsonBean gsonBean);
        void onJsonFailure(Throwable throwable);
        //流式布局 的成功失败
        void onFlwoSuccess(FlowBean flowBean);
        void onFlwoFailure(Throwable throwable);
    }
    interface Ipresenter{
        void getJsonData(String name);
        void getFlowData(String name);
    }
    interface Imodel{
        void getJsonData(String name,IgsonModelCallBck igsonModelCallBck);

        interface IgsonModelCallBck{
            //json 数据的成功失败
            void onJsonSuccess(GsonBean gsonBean);
            void onJsonFailure(Throwable throwable);
        }
        void getFlowData(String name,IflowModelCallBck iflowModelCallBck);
        interface IflowModelCallBck{
            //流式布局 的成功失败
            void onFlwoSuccess(FlowBean flowBean);
            void onFlwoFailure(Throwable throwable);
        }
    }
}
