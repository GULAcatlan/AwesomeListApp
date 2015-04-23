package com.awsmsoft.awesomelistapp.fragments.tutorial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.awsmsoft.awesomelistapp.R;

public class HomeTutorialFragment extends Fragment {
    private String title;
    private int page;

    private static HomeTutorialFragment mInstance;

    public static Fragment getInstance(int page, String title) {
        if (mInstance == null) {
            mInstance = new HomeTutorialFragment();

            Bundle args = new Bundle();
            args.putInt("someInt", page);
            args.putString("someTitle", title);

            mInstance.setArguments(args);
        }

        return mInstance;
    }

    public HomeTutorialFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someString1");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tutorial_fragment_home, container, false);
        TextView content = (TextView) view.findViewById(R.id.tutorialHomeContent);
        content.setText(page + " -- " + title);
        return view;
    }
}