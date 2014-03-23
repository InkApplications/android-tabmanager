package com.inkapplications.tabmanager;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Build;

import static com.inkapplications.tabmanager.Preconditions.checkNotNull;

/** Class containing all information needed to construct a tab */
@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
public class TabContent {

    private Integer mTabIcon;
    private String mTabTitle;
    private Class<? extends Fragment> mTabContentFragment;
    private ActionBar.TabListener mTabListener;

    /**
     * Constructor
     *
     * @param tabTitle           title of the tab
     * @param tabContentFragment fragment that is displayed when a fragment is on screen
     */
    public TabContent(String tabTitle, Class<? extends Fragment> tabContentFragment) {
        this(tabTitle, tabContentFragment, null);
    }

    /**
     * Constructor
     *
     * @param tabTitle           title of the tab
     * @param tabContentFragment fragment that is displayed when a fragment is on screen
     * @param tabIcon            resource id of the icon to draw.  May be null if you do not want an
     *                           icon
     */
    public TabContent(
            String tabTitle,
            Class<? extends Fragment> tabContentFragment,
            Integer tabIcon
    ) {
        this(tabTitle, checkNotNull(tabContentFragment), tabIcon, null);
    }

    /**
     * Constructor
     *
     * @param tabTitle    title of the tab
     * @param tabIcon     resource id of the icon to draw.  May be null if you do not want an icon
     * @param tabListener create a custom tab listener
     */
    public TabContent(
            String tabTitle,
            Integer tabIcon,
            ActionBar.TabListener tabListener
    ) {
        this(tabTitle, null, tabIcon, checkNotNull(tabListener));
    }

    /**
     * Constructor - Private since everything else you would need can be accomplished in the other
     * constructors and they all just route here.  Tablistner and FragmentListener can not both be
     * null, other constructors check for this
     *
     * @param tabTitle           title of the tab
     * @param tabContentFragment fragment that is displayed when a fragment is on screen
     * @param tabIcon            resource id of the icon to draw.  May be null if you do not want an
     *                           icon
     * @param tabListener        create a custom tab listener
     */
    private TabContent(
            String tabTitle,
            Class<? extends Fragment> tabContentFragment,
            Integer tabIcon,
            ActionBar.TabListener tabListener
    ) {
        mTabTitle = checkNotNull(tabTitle);
        mTabContentFragment = tabContentFragment;
        mTabIcon = tabIcon;
        mTabListener = tabListener;
    }

    public String getTabTitle() {
        return mTabTitle;
    }

    public void setTabTitle(String tabTitle) {
        mTabTitle = checkNotNull(tabTitle);
    }

    public Class<? extends Fragment> getTabContentFragment() {
        return mTabContentFragment;
    }

    public void setTabContentFragment(Class<? extends Fragment> tabContentFragment) {
        mTabContentFragment = checkNotNull(tabContentFragment);
    }

    public Integer getTabIcon() {
        return mTabIcon;
    }

    public void setTabIcon(Integer tabIcon) {
        mTabIcon = tabIcon;
    }

    public ActionBar.TabListener getTabListener() {
        return mTabListener;
    }

    public void setTabListener(TabListener tabListener) {
        mTabListener = tabListener;
    }
}
