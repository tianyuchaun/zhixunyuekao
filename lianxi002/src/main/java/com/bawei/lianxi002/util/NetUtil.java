package com.bawei.lianxi002.util;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.lianxi002.App;

import java.util.Map;

public class NetUtil {
    private static NetUtil netUtil;
    private final RequestQueue requestQueue;

    public NetUtil() {
        requestQueue = Volley.newRequestQueue(App.app);
    }

    public static NetUtil getInstance() {
        if (netUtil == null) {
            synchronized (NetUtil.class) {
                if (netUtil == null) {
                    netUtil = new NetUtil();
                }
            }
        }
        return netUtil;
    }

    public void onGetJsonGet(String httpUrl, final MyCallBack myCallBack) {
        Log.d("xx", httpUrl);
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
    public void onGetJsonPost(String httpUrl, Map<String,String> map, final MyCallBack myCallBack) {
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
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        requestQueue.add(stringRequest);
    }
    public interface MyCallBack {
        void onGetJson(String json);

        void onError(Throwable throwable);
    }
}
