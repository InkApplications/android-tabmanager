package com.inkapplications.tabmanager.support;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;

import static com.inkapplications.tabmanager.support.Preconditions.checkNotNull;

/**
 * Abstract class for easily creating tab listeners
 * <p/>
 * Just override @{link #createTabFragment} to return the fragment to be displayed
 */
public abstract class SimpleTabListener implements ActionBar.TabListener {

    private Fragment fragment;
    private final String tag;
    private final int viewId;

    /**
     * Defaults to attaching fragment to android.R.id.content
     *
     * @param tag identifying tag of the fragment
     */
    public SimpleTabListener(String tag) {
        this.tag = tag;
        this.viewId = android.R.id.content;
    }

    /**
     * @param tag    identifying tag of the fragment
     * @param viewId viewId the tabs should be attached too
     */
    public SimpleTabListener(String tag, int viewId
    ) {
        this.tag = checkNotNull(tag);
        this.viewId = viewId;
    }

    /** {@inheritDoc} */
    @Override public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // Check if the fragment is already initialized
        if (fragment == null) {
            // it's not instantiated and add to the activity
            fragment = createTabFragment();
            ft.replace(viewId, fragment, tag);
        } else {
            // Already exists attach it
            ft.attach(fragment);
        }
    }

    /** {@inheritDoc} */
    @Override public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (fragment != null) {
            // Detach the fragment, b/c another is being attached
            ft.detach(fragment);
        }
    }

    /** {@inheritDoc} */
    @Override public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        // User selected the tab that is already selected
        // Do nothing
    }

    /**
     * Create the fragment that this tab will display
     *
     * @return the fragment to display
     */
    protected abstract Fragment createTabFragment();
}
