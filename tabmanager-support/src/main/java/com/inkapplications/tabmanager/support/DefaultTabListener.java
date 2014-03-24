package com.inkapplications.tabmanager.support;

import android.support.v4.app.Fragment;
import android.content.Context;

import static com.inkapplications.tabmanager.support.Preconditions.checkNotNull;

/**
 * Listener for when a tab is pressed.
 * It is responsible for displaying the content of the tab selected.
 */
public class DefaultTabListener extends SimpleTabListener {

    private final Context context;
    private final Class clazz;

    /**
     * Constructs a new DefaultTabListener
     *
     * @param context context used to instantiate the enclosing fragment
     * @param tag     identifying tag of the fragment
     * @param clazz   the fragment's class used to instantiate the fragment
     * @param viewId  Id the tabs should be attached too
     */
    public DefaultTabListener(
            Context context,
            String tag,
            Class<? extends Fragment> clazz,
            int viewId
    ) {
        super(tag, viewId);
        this.context = checkNotNull(context).getApplicationContext();
        this.clazz = checkNotNull(clazz);
    }

    /** Creates the fragment from the class that was passed in */
    @Override protected Fragment createTabFragment() {
        return Fragment.instantiate(context, clazz.getName());
    }
}
