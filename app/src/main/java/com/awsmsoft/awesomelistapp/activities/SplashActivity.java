package com.awsmsoft.awesomelistapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.awsmsoft.awesomelistapp.R;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        checkNextScreen();
    }

    private void checkNextScreen() {
        SharedPreferences preferences = getSharedPreferences(getString(R.string.preferences), MODE_PRIVATE);

        startActivity(new Intent(this, preferences.getBoolean(getString(R.string.userLogged), false) ? MainActivity.class : TutorialActivity.class));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 3000);
    }
}