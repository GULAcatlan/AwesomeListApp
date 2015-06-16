package com.awsmsoft.awesomelistapp.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.awsmsoft.awesomelistapp.R;
import com.awsmsoft.awesomelistapp.fragments.HeaderFragment;
import com.awsmsoft.awesomelistapp.fragments.MenuFragment;
import com.awsmsoft.awesomelistapp.fragments.PlayerFragment;
import com.awsmsoft.awesomelistapp.utils.Helpers;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        HeaderFragment header = new HeaderFragment();
        MenuFragment menu = new MenuFragment();
        PlayerFragment player = new PlayerFragment();

        Helpers.fragmentChooserWithoutAddToBackStack(R.id.frameLayoutHeader, header, getSupportFragmentManager(), getString(R.string.tag_fragment_header));
        Helpers.fragmentChooserWithoutAddToBackStack(R.id.frameLayoutMenu, menu, getSupportFragmentManager(), getString(R.string.tag_fragment_menu));
        Helpers.fragmentChooserWithoutAddToBackStack(R.id.frameLayoutHeader, player, getSupportFragmentManager(), getString(R.string.tag_fragment_player));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}