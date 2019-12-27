package com.bawei.lianxi002.base;

public abstract class BasePresenter<V> {
    public V view;

    public void attach(V view) {
        this.view = view;
    }
    public void detach() {
        view = null;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
