package com.awsmsoft.awesomelistapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.awsmsoft.awesomelistapp.R;

public class SplashActivity extends Activity {

    protected boolean _active = true;
    protected int _splashTime = 3000; // time to display the splash screen in ms

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(100);
                        if (_active) {
                            waited += 100;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    SharedPreferences preferences = getSharedPreferences(getString(R.string.preferences), MODE_PRIVATE);
                    boolean isInstalled = preferences.getBoolean(getString(R.string.appInstalled), false);

                    if (isInstalled) {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    } else {
                        startActivity(new Intent(SplashActivity.this, TutorialActivity.class));
                    }

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean(getString(R.string.appInstalled), true);
                    editor.apply();
                    finish();
                }
            }

            ;
        };
        splashTread.start();
    }
}