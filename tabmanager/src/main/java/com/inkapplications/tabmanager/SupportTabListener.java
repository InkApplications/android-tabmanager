package com.inkapplications.tabmanager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;

import static com.inkapplications.tabmanager.Preconditions.checkNotNull;

/**
 * Listener for when a tab is pressed.
 * It is responsible for displaying the content of the tab selected.
 */
public class SupportTabListener implements ActionBar.TabListener {

    private Fragment mFragment;
    private final Context mContext;
    private final String mTag;
    private final Class mClass;
    private final int mResourceId;

    /**
     * Constructs a new TabListner
     *
     * @param context    context used to instantiate the enclosing fragment
     * @param tag        identifying tag of the fragment
     * @param clazz      the fragment's class used to instantiate the fragment
     * @param resourceId resourceId the tabs should be attached too
     */
    public SupportTabListener(
            Context context,
            String tag,
            Class<? extends Fragment> clazz,
            int resourceId
    ) {
        mContext = checkNotNull(context).getApplicationContext();
        mTag = checkNotNull(tag);
        mClass = checkNotNull(clazz);
        mResourceId = resourceId;
    }

    /** {@inheritDoc} **/
    @Override public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // Check if the fragment is already initialized
        if (mFragment == null) {
            // it's not instantiated and add to the activity
            mFragment = Fragment.instantiate(mContext, mClass.getName());
            ft.replace(mResourceId, mFragment, mTag);
        } else {
            // Already exists attach it
            ft.attach(mFragment);
        }
    }

    /** {@inheritDoc} **/
    @Override public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (mFragment != null) {
            // Detach the fragment, b/c another is being attached
            ft.detach(mFragment);
        }
    }

    /** {@inheritDoc} **/
    @Override public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        // User selected the tab that is already selected
        // Do nothing
    }
}
