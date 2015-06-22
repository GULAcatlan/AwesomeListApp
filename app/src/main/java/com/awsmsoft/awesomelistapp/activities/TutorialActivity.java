package com.awsmsoft.awesomelistapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.awsmsoft.awesomelistapp.fragments.tutorial.StartTutorialFragment;

public class TutorialActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {
    private int totalSections = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        initViews();
    }

    private void initViews() {
        Fragment[] fragments = new Fragment[]{
                StartTutorialFragment.getInstance(0, "Start"),
                HomeTutorialFragment.getInstance(1, "Home"),
                ProfileTutorialFragment.getInstance(2, "Profile")
        };

        ViewPager viewPager = (ViewPager) findViewById(R.id.tutorialViewPager);
        viewPager.setAdapter(new TutorialPagerAdapter(getSupportFragmentManager(), fragments));
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    protected void onDestroy() {
        ((ViewPager)findViewById(R.id.tutorialViewPager)).removeOnPageChangeListener(this);

        super.onDestroy();
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == totalSections) {
            SharedPreferences preferences = getSharedPreferences(getString(R.string.preferences), MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            editor.putBoolean(getString(R.string.appInstalled), true);
            editor.apply();

            Intent main = new Intent(this, MainActivity.class);
            //Do stuff
            startActivity(main);
            finish();
        }
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
