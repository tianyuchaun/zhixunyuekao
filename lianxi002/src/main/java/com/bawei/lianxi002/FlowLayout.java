package com.bawei.lianxi002;

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
        //测量父控件的宽
        widthPixels = getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        //定义间隙
        int wSpace = 30;
        int hSpace = 20;

        //定义初始控件位置
        int left = wSpace;
        int top = hSpace;
        int right = 0;
        int bottom = 0;

        int childCount = getChildCount();

        for (int j = 0; j < childCount; j++) {
            View childAt = getChildAt(j);

            childAt.measure(0, 0);

            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();

            right = left + measuredWidth;

            if (right > widthPixels) {
                left = wSpace;
                top = hSpace + bottom;
                right = left + measuredWidth;
                bottom = top + measuredHeight;
            } else {
                bottom = top + measuredHeight;
            }
            childAt.layout(left, top, right, bottom);

            left = right + wSpace;
        }
    }

    //添加文本子控件
    public void addTag(final String tag) {
        final TextView textView = new TextView(getContext());
        textView.setText(tag);
        addView(textView);
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onFlowItmeClick != null) {
                    onFlowItmeClick.onClick(tag);
                }
            }
        });
    }



    OnFlowItmeClick onFlowItmeClick;

    public void setOnFlowItmeClick(OnFlowItmeClick onFlowItmeClick) {
        this.onFlowItmeClick = onFlowItmeClick;
    }

    interface OnFlowItmeClick {
        void onClick(String tag);
    }
}
