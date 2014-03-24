package com.inkapplications.tabmanager.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;

public class CustomTabListener2 implements ActionBar.TabListener {
    private final String fragmentContent;
    private Fragment fragment;

    public CustomTabListener2(String fragmentContent) {
        this.fragmentContent = fragmentContent;
    }

    @Override public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // Check if the fragment is already initialized
        if (fragment == null) {
            // it's not instantiated and add to the activity
            fragment = ExampleFragment2.newInstance(fragmentContent);
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
