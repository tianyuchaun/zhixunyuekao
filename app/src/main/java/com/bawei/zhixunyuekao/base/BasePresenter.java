package com.bawei.zhixunyuekao.base;

public abstract class BasePresenter<V> {
    protected V view;

    public void attavh(V view) {
        this.view = view;
    }
    public void detavh() {
       view = null;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();


}
