package com.inkapplications.tabmanager.support;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import static com.inkapplications.tabmanager.support.Preconditions.checkNotNull;

/** Class for simplifying the use of actionbar tabs */
public class TabManager {

    private final ActionBarActivity activity;
    private int resourceId = android.R.id.content;

    /**
     * Creates the TabManager that will use {@link android.R.id#content} as the id to attach to
     *
     * @param activity current activity to attach the tabs to
     */
    public TabManager(ActionBarActivity activity) {
        this.activity = checkNotNull(activity);
    }

    /**
     * Creates the TabManager
     *
     * @param activity   current activity to attach the tabs to
     * @param resourceId resource id the tab content should be attached too, for example
     *                   android.R.id.content to attach to the entire available content area, or
     *                   the main layout of a fragment.
     */
    public TabManager(ActionBarActivity activity, int resourceId) {
        this.activity = checkNotNull(activity);
        this.resourceId = resourceId;
    }

    /**
     * Creates the new tabs on the activity
     *
     * @param tabContents List containing info to construct all tabs
     */
    public void create(TabContent... tabContents) {
        checkNotNull(tabContents);

        ActionBar actionBar = checkNotNull(activity.getSupportActionBar());
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.removeAllTabs();

        for (TabContent tabContent : tabContents) {
            Class<? extends Fragment> fragmentClass = tabContent.getTabContentFragment();
            ActionBar.TabListener tabListener = tabContent.getTabListener();
            if (tabListener == null) {
                tabListener = new DefaultTabListener(
                        activity,
                        fragmentClass.getName(),
                        fragmentClass,
                        resourceId
                );
            }

            ActionBar.Tab tab = actionBar.newTab()
                    .setText(
                            tabContent.getTabTitle()
                    )
                    .setTabListener(
                            tabListener
                    );

            Integer tabIcon = tabContent.getTabIcon();
            if (tabIcon != null) {
                tab.setIcon(tabIcon);
            }

            actionBar.addTab(tab);
        }
    }

    /**
     * Removes all the tabs on the activity
     */
    public void removeAll() {
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
            actionBar.removeAllTabs();
        }
    }
}
