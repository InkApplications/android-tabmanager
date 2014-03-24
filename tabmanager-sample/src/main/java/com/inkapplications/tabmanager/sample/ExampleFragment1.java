package com.inkapplications.tabmanager.sample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ExampleFragment1 extends Fragment {
    @Override
    @SuppressWarnings("ConstantConditions")
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_example, container, false);
        TextView textView = (TextView) view.findViewById(R.id.example_textview);
        textView.setText(getString(R.string.fragment_one));
        return view;
    }
}
