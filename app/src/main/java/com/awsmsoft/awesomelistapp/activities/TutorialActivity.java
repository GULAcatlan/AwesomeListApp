package com.awsmsoft.awesomelistapp.activities;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.awsmsoft.awesomelistapp.R;

public class TutorialActivity extends FragmentActivity {

    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new PageAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
    }

    public static class PageAdapter extends FragmentPagerAdapter{
        private static int NUM_ITEMS = 2;


        public PageAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }



        @Override
        public int getCount(){
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position){
            switch(position){
                case 0:
                    return Tutorial1.newInstance(0,"Page #1");
                case 1:
                    return Tutorial2.newInstance(1,"Page #2");
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position){
            return "Page " + position;
        }
    }


}
