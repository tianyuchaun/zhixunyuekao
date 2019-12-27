package com.bawei.lianxi001.view.activity;

import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.bawei.lianxi001.base.BaseActivity;
import com.bawei.lianxi001.base.BasePresenter;
import com.bawei.zhixunyuekao.R;


public class Main2Activity extends BaseActivity {


    private WebView wb;
    private Button bt1, bt2;


    @Override
    protected void initData() {

        wb.getSettings().setJavaScriptEnabled(true);

        wb.setWebViewClient(new WebViewClient());
        wb.setWebChromeClient(new WebChromeClient());
        wb.addJavascriptInterface(new JsToAndroid(), "android");
        wb.loadUrl("file:///android_asset/Baibai.html");
    }

    @Override
    protected void initView() {
        wb = findViewById(R.id.wb);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wb.loadUrl("javascript:jsFunction1()");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wb.loadUrl("javascript:jsFunction2('我来自于 Android 世界')");
            }
        });
    }

    @Override
    protected BasePresenter Apresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main2;
    }

    public class JsToAndroid {
        @JavascriptInterface
        public void getAndroidData() {
            Log.d("xx", "JS调用了无参构造函数");
            Toast.makeText(Main2Activity.this, "JS调用了无参构造函数", Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface
        public void getAndroidXxxData(String data) {
            Log.d("xx", "" + data);
            Toast.makeText(Main2Activity.this, "" + data, Toast.LENGTH_SHORT).show();
        }
    }
}
