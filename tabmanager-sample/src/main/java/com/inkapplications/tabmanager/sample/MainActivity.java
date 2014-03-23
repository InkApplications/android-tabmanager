package com.inkapplications.tabmanager.sample;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
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

        ActionBar.TabListener tabListener3 = new CustomTabListener(getString(R.string.fragment_three));

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

        private String text;

        public static ExampleFragment3 newInstance(String text) {
            ExampleFragment3 fragment = new ExampleFragment3();
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

    static final class CustomTabListener implements ActionBar.TabListener {
        private final String fragmentContent;
        private Fragment fragment;

        public CustomTabListener(String fragmentContent) {
            this.fragmentContent = fragmentContent;
        }

        @Override public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            // Check if the fragment is already initialized
            if (fragment == null) {
                // it's not instantiated and add to the activity
                fragment = ExampleFragment3.newInstance(fragmentContent);
                ft.replace(android.R.id.content, fragment, "ExampleTag");
            } else {
                // Already exists attach it
                ft.attach(fragment);
            }
        }

        @Override public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            if (fragment != null) {
                // Detach the fragment, b/c another is being attached
                ft.detach(fragment);
            }
        }

        @Override public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    }
}
