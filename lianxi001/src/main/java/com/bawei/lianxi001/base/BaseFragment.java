package com.bawei.lianxi001.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected P pPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View inflate = View.inflate(getActivity(), layoutId(), null);
        pPresenter = Fpresenter();
        if (pPresenter != null) {
            pPresenter.attach(this);
        }
        initView(inflate);
        return inflate;
    }

    protected abstract void initView(View inflate);

    protected abstract P Fpresenter();

    protected abstract int layoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (pPresenter != null) {
            pPresenter.detach();
        }
    }
}
