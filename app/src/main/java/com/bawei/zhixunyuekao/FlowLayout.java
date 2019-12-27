package com.bawei.zhixunyuekao;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FlowLayout extends ViewGroup {

    private int widthPixels;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        //容器宽
        widthPixels = getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //定义间隙
        int wSpace=30;
        int hSpace=20;
        //定义初始控件位置
        int left=wSpace;
        int top=hSpace;
        int right=0;
        int bottom=0;
        //获取子控件数量
        int childCount = getChildCount();
        //遍历
        for (int i=0;i<childCount;i++){
            //获取子控件
            View child = getChildAt(i);
            //测量子控件
            child.measure(0,0);
            //获取子控件的宽高
            int measuredWidth = child.getMeasuredWidth();
            int measuredHeight = child.getMeasuredHeight();

            right=left+measuredWidth;
            //换行
            if (right>widthPixels){
                left=wSpace;
                top=bottom+hSpace;
                right=left+measuredWidth;
                bottom=top+measuredHeight;
            }else {
                bottom=top+measuredHeight;
            }
            //子控件位置
            child.layout(left,top,right,bottom);
            //下个子控件的左位置
            left=right+wSpace;
        }
    }
    //添加文本的方法
    public void addTag(final String tag){
        TextView textView = new TextView(getContext());
        textView.setText(tag);
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getContext(), ""+tag, Toast.LENGTH_SHORT).show();
                if (onTagItimClick != null) {
                    onTagItimClick.onClick(tag);
                }
            }
        });
        addView(textView);
    }
    OnTagItimClick onTagItimClick;

    public void setOnTagItimClick(OnTagItimClick onTagItimClick) {
        this.onTagItimClick = onTagItimClick;
    }

    public interface OnTagItimClick{
        void onClick(String tag);
    }

}
