package com.bawei.ks1223.beas;

public abstract class BeasPresenter<V> {
    protected  V view;

    public void attach(V view) {
        this.view = view;
    }
    public void detach() {
        view = null;
    }

    public BeasPresenter() {
        initModel();
    }

    protected abstract void initModel();
}
