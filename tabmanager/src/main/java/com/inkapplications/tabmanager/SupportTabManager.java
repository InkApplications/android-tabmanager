package com.inkapplications.tabmanager;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import static com.inkapplications.tabmanager.Preconditions.checkNotNull;

/**  Class for simplifying the use of actionbar tabs */
public class SupportTabManager {

    private final ActionBarActivity mActivity;
    private int mResourceId = android.R.id.content;

    /**
     * Creates the SupportTabManager that will use {@link android.R.id#content} as the id to attach to
     *
     * @param activity current activity to attach the tabs to
     */
    public SupportTabManager(ActionBarActivity activity) {
        mActivity = checkNotNull(activity);
    }

    /**
     * Creates the SupportTabManager
     *
     * @param activity   current activity to attach the tabs to
     * @param resourceId resource id the tab content should be attached too, for example
     *                   android.R.id.content to attach to the entire available content area, or
     *                   the main layout of a fragment.
     */
    public SupportTabManager(ActionBarActivity activity, int resourceId) {
        mActivity = checkNotNull(activity);
        mResourceId = resourceId;
    }

    /**
     * Creates the new tabs on the activity
     *
     * @param supportTabContents List containing info to construct all tabs
     */
    public void create(SupportTabContent... supportTabContents) {
        checkNotNull(supportTabContents);

        ActionBar actionBar = checkNotNull(mActivity.getSupportActionBar());
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.removeAllTabs();

        for (SupportTabContent supportTabContent : supportTabContents) {
            Class<? extends Fragment> fragmentClass = supportTabContent.getTabContentFragment();
            ActionBar.TabListener tabListener = supportTabContent.getTabListener();
            if (tabListener == null) {
                tabListener = new SupportTabListener(
                        mActivity,
                        fragmentClass.getName(),
                        fragmentClass,
                        mResourceId
                );
            }

            ActionBar.Tab tab = actionBar.newTab()
                    .setText(
                            supportTabContent.getTabTitle()
                    )
                    .setTabListener(
                            tabListener
                    );

            Integer tabIcon = supportTabContent.getTabIcon();
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
        ActionBar actionBar = mActivity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
            actionBar.removeAllTabs();
        }
    }
}
