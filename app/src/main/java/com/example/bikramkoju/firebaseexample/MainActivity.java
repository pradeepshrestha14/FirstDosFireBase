package com.example.bikramkoju.firebaseexample;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends AppCompatActivity {
    PagerSlidingTabStrip pagertab;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagertab=(PagerSlidingTabStrip)findViewById(R.id.pager_tabs);
        viewPager=(ViewPager)findViewById(R.id.viewpager);


        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(this,fragmentManager));
        pagertab.setViewPager(viewPager);

    }


    private class MyAdapter extends FragmentStatePagerAdapter {
        Context c;
        public MyAdapter(FragmentActivity mainActivity, FragmentManager fragmentManager) {
        super(fragmentManager);
            c=mainActivity;
        }


        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new AddFragment();
                case 1:
                    return new ViewFragment();
            }
            return null;
        }

        @Override
        public int getCount() {return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "ADD";
                case 1:
                    return "View";
            }
            return null;
        }
    }
}
