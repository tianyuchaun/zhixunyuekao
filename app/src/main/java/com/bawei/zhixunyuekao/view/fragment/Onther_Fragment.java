package com.bawei.zhixunyuekao.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.zhixunyuekao.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Onther_Fragment extends Fragment {


    private TextView tv;

    public Onther_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_onther, container, false);
        tv = view.findViewById(R.id.tv);
        String key = getArguments().getString("key");
        tv.setText(key);

        return view;
    }

    public static Onther_Fragment getInstance(String name) {
        Onther_Fragment onther_fragment = new Onther_Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",name);
        onther_fragment.setArguments(bundle);
        return onther_fragment;
    }
}
