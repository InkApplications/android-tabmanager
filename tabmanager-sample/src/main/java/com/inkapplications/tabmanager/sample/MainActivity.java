package com.inkapplications.tabmanager.sample;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

import com.inkapplications.tabmanager.TabContent;
import com.inkapplications.tabmanager.TabManager;


public class MainActivity extends Activity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabManager tabManager = new TabManager(this);

        TabContent tabContent1 = new TabContent(
                getString(R.string.tab1),
                ExampleFragment1.class,
                android.R.drawable.ic_menu_add
        );

        ActionBar.TabListener tabListener2 = new CustomTabListener1(getString(R.string.fragment_two));
        TabContent tabContent2 = new TabContent(
                getString(R.string.tab2),
                android.R.drawable.ic_menu_add,
                tabListener2
        );

        ActionBar.TabListener tabListener3 = new CustomTabListener2(getString(R.string.fragment_three));

        TabContent tabContent3 = new TabContent(
                getString(R.string.tab_three),
                android.R.drawable.ic_btn_speak_now,
                tabListener3
        );

        tabManager.create(tabContent1, tabContent2, tabContent3);
    }
}
