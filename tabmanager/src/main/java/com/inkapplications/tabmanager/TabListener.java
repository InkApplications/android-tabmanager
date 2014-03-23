package com.inkapplications.tabmanager;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Build;

import static com.inkapplications.tabmanager.Preconditions.checkNotNull;

/**
 * Listener for when a tab is pressed.
 * It is responsible for displaying the content of the tab selected.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
public class TabListener implements ActionBar.TabListener {

    private Fragment mFragment;
    private final Context mContext;
    private final String mTag;
    private final Class mClass;
    private final int mResourceId;

    /**
     * Constructs a new TabListener
     *
     * @param context    context used to instantiate the enclosing fragment
     * @param tag        identifying tag of the fragment
     * @param clazz      the fragment's class used to instantiate the fragment
     * @param resourceId resourceId the tabs should be attached too
     */
    public TabListener(
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

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
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

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (mFragment != null) {
            // Detach the fragment, b/c another is being attached
            ft.detach(mFragment);
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        // User selected the tab that is already selected
        // Do nothing
    }
}
