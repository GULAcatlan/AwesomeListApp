package com.awsmsoft.awesomelistapp.fragments.tutorial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.awsmsoft.awesomelistapp.R;

/**
 * Created by sierisimo on 22/04/15.
 */
public class StartTutorialFragment extends Fragment {
    private String title;
    private int page;

    private static StartTutorialFragment mInstance;

    public static StartTutorialFragment getInstance(int page, String title) {
        if (mInstance == null) {
            mInstance = new StartTutorialFragment();

            Bundle args = new Bundle();
            args.putInt("someInt", page);
            args.putString("someTitle", title);

            mInstance.setArguments(args);
        }

        return mInstance;
    }

    public StartTutorialFragment() {
        //Required empty constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt");
        title = getArguments().getString("someTitle");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tutorial_fragment_start, container, false);

        TextView content = (TextView) view.findViewById(R.id.tutorialStartContent);
        content.setText(page + " -- " + title);
        return view;
    }
}
