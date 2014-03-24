package com.inkapplications.tabmanager.sample;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ExampleFragment2 extends Fragment {

    private String text;

    public static ExampleFragment2 newInstance(String text) {
        ExampleFragment2 fragment = new ExampleFragment2();
        fragment.text = text;
        return fragment;
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_example, container, false);
        TextView textView = (TextView) view.findViewById(R.id.example_textview);
        textView.setText(text);
        return view;
    }
}
