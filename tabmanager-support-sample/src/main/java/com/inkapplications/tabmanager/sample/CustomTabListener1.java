package com.inkapplications.tabmanager.sample;

import android.support.v4.app.Fragment;

import com.inkapplications.tabmanager.support.SimpleTabListener;

public class CustomTabListener1 extends SimpleTabListener {

    private final String fragmentContent;

    public CustomTabListener1(String fragmentContent) {
        super("ExampleTag");
        this.fragmentContent = fragmentContent;
    }

    @Override protected Fragment createTabFragment() {
        return ExampleFragment2.newInstance(fragmentContent);
    }
}
