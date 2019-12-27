package com.bawei.lianxi001.view.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.lianxi001.view.fragment.Home_Fragment;
import com.bawei.lianxi001.view.fragment.Onther_Fragment;
import com.bawei.zhixunyuekao.R;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    ArrayList<Fragment> list = new ArrayList<>();
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.vp);

        rg = findViewById(R.id.rg);

        Home_Fragment home_fragment = new Home_Fragment();
        Onther_Fragment onther_fragment1 = Onther_Fragment.getInstance("北京");
        Onther_Fragment onther_fragment2 = Onther_Fragment.getInstance("我的");
        list.add(home_fragment);
        list.add(onther_fragment1);
        list.add(onther_fragment2);

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        vp.setCurrentItem(2);
                        break;
                }
            }
        });
    }
}
