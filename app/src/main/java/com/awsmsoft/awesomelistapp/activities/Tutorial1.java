package com.awsmsoft.awesomelistapp.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.awsmsoft.awesomelistapp.R;

public class Tutorial1 extends Fragment {

    private String title;
    private int page;

    public static Tutorial1 newInstance(int page, String title){

        Tutorial1 tutorial1 = new Tutorial1();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        tutorial1.setArguments(args);
        return tutorial1;
    }


    public Tutorial1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt",0);
        title = getArguments().getString("someString1");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutorial1, container, false);
        TextView content = (TextView) view.findViewById(R.id.content);
        content.setText(page + " -- " + title);
        return view;
    }



}
