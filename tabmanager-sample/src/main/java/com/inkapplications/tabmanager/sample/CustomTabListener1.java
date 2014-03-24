package com.inkapplications.tabmanager.sample;

import android.app.Fragment;

import com.inkapplications.tabmanager.SimpleTabListener;

public class CustomTabListener1 extends SimpleTabListener {

    private final String fragmentContent;

    public CustomTabListener1(String fragmentContent) {
        super(CustomTabListener1.class.getCanonicalName());
        this.fragmentContent = fragmentContent;
    }

    @Override protected Fragment createTabFragment() {
        return ExampleFragment2.newInstance(fragmentContent);
    }
}
