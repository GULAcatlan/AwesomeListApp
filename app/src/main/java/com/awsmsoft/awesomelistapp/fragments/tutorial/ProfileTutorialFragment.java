package com.awsmsoft.awesomelistapp.fragments.tutorial;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.awsmsoft.awesomelistapp.R;

public class ProfileTutorialFragment extends Fragment {
    private String title;
    private int page;

    private static ProfileTutorialFragment mInstance;

    public static ProfileTutorialFragment newInstance(int page, String title) {
        ProfileTutorialFragment profileTutorialFragment = new ProfileTutorialFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        profileTutorialFragment.setArguments(args);
        return profileTutorialFragment;
    }

    public static Fragment getInstance() {
        if (mInstance == null) {
            mInstance = newInstance(1,"Tutorial");
        }

        return mInstance;
    }

    public ProfileTutorialFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            page = getArguments().getInt("someInt", 1);
            title = getArguments().getString("someTitle");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tutorial_fragment_prodile, container, false);
        TextView content = (TextView) view.findViewById(R.id.content);
        content.setText(page + " -- " + title);
        return view;
    }


}
