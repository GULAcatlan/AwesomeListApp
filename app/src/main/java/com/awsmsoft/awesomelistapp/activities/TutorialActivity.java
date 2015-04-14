package com.awsmsoft.awesomelistapp.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;

import com.awsmsoft.awesomelistapp.R;
import com.awsmsoft.awesomelistapp.fragments.tutorial.HomeTutorialFragment;
import com.awsmsoft.awesomelistapp.fragments.tutorial.ProfileTutorialFragment;

public class TutorialActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        initViews();
    }

    private void initViews() {
        Fragment[] fragments = new Fragment[]{
                HomeTutorialFragment.getInstance(),
                ProfileTutorialFragment.getInstance()
        };

        ViewPager viewPager = (ViewPager) findViewById(R.id.tutorialViewPager);
        viewPager.setAdapter(new TutorialPagerAdapter(getSupportFragmentManager(), fragments));
        viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * Inner class that is only used at this activity, no need to use in another place
     */
    private class TutorialPagerAdapter extends FragmentPagerAdapter {
        private SparseArray<Fragment> registeredFragments;

        public TutorialPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            registeredFragments = new SparseArray<>();
        }

        public TutorialPagerAdapter(FragmentManager fragmentManager, Fragment[] fragments) {
            this(fragmentManager);
            for (int i = 0; i < fragments.length; i++) {
                registeredFragments.put(i, fragments[i]);
            }
        }

        @Override
        public Fragment getItem(int position) {
            return registeredFragments.get(position);
        }

        @Override
        public int getCount() {
            return registeredFragments.size();
        }
    }
}