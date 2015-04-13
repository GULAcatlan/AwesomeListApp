package com.awsmsoft.awesomelistapp.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.awsmsoft.awesomelistapp.R;

import org.w3c.dom.Text;

public class Tutorial2 extends Fragment {

    private String title;
    private int page;

    public static Tutorial2 newInstance(int page, String title) {
        Tutorial2 tutorial2 = new Tutorial2();
        Bundle args = new Bundle();
        args.putInt("someInt",page);
        args.putString("someTitle", title);
        tutorial2.setArguments(args);
        return tutorial2;
    }

    public Tutorial2() {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutorial2, container, false);
        TextView content = (TextView) view.findViewById(R.id.content);
        content.setText(page + " -- " + title);
        return view;
    }


}
