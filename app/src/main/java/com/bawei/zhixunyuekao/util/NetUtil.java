package com.bawei.zhixunyuekao.util;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.zhixunyuekao.App;

public class NetUtil {
    public static NetUtil netUtil;
    private final RequestQueue requestQueue;

    public NetUtil() {
        requestQueue = Volley.newRequestQueue(App.app);
    }

    public static NetUtil getInstance() {
        if (netUtil == null) {
            synchronized (NetUtil.class){
            if (netUtil == null) {
                netUtil = new NetUtil();
            }
        }

        }
        return netUtil;
    }
//请求方式 为GET;
    public void onGetJsonGget(String httpUrl, final MyCallBack myCallBack){
        Log.d("xx" ,httpUrl);
        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, httpUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallBack.onGetJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            myCallBack.onError(error);
            }
        });
        requestQueue.add(stringRequest);
    }
    //接口
    public interface MyCallBack{
        void onGetJson(String json);
        void onError(Throwable throwable);
    }
}
