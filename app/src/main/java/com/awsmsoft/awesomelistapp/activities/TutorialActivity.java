package com.awsmsoft.awesomelistapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.awsmsoft.awesomelistapp.R;

public class TutorialActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        Log.w("Actividad","Tutorial");

    }
}
