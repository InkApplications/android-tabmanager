package com.inkapplications.tabmanager.sample;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inkapplications.tabmanager.TabContent;
import com.inkapplications.tabmanager.TabListener;
import com.inkapplications.tabmanager.TabManager;


public class MainActivity extends Activity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabManager tabManager = new TabManager(this);

        TabContent tabContent1 = new TabContent(
                getString(R.string.tab1),
                ExampleFragment1.class
        );

        TabContent tabContent2 = new TabContent(
                getString(R.string.tab2),
                ExampleFragment2.class,
                android.R.drawable.ic_menu_add
        );

        TabListener tabListener3 = new TabListener(
                this,
                "testTag",
                ExampleFragment3.class,
                android.R.id.content
        );
        TabContent tabContent3 = new TabContent(
                getString(R.string.tab_three),
                android.R.drawable.ic_btn_speak_now,
                tabListener3
        );

        tabManager.create(tabContent1, tabContent2, tabContent3);
    }

    public static final class ExampleFragment1 extends Fragment {
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

    public static final class ExampleFragment2 extends Fragment {
        @Override
        @SuppressWarnings("ConstantConditions")
        public View onCreateView(
                LayoutInflater inflater,
                ViewGroup container,
                Bundle savedInstanceState
        ) {
            View view = inflater.inflate(R.layout.fragment_example, container, false);
            TextView textView = (TextView) view.findViewById(R.id.example_textview);
            textView.setText(getString(R.string.fragment_two));
            return view;
        }
    }

    public static final class ExampleFragment3 extends Fragment {
        @Override
        @SuppressWarnings("ConstantConditions")
        public View onCreateView(
                LayoutInflater inflater,
                ViewGroup container,
                Bundle savedInstanceState
        ) {
            View view = inflater.inflate(R.layout.fragment_example, container, false);
            TextView textView = (TextView) view.findViewById(R.id.example_textview);
            textView.setText(getString(R.string.fragment_three));
            return view;
        }
    }
}
