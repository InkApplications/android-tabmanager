package com.inkapplications.tabmanager;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;

import static com.inkapplications.tabmanager.Preconditions.checkNotNull;

/** Class containing all information needed to construct a tab */
public class SupportTabContent {

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
    public SupportTabContent(String tabTitle, Class<? extends Fragment> tabContentFragment) {
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
    public SupportTabContent(
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
    public SupportTabContent(
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
    private SupportTabContent(
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

    /** Gets the title of this tab */
    public String getTabTitle() {
        return mTabTitle;
    }

    /** Set the title of this tab */
    public void setTabTitle(String tabTitle) {
        mTabTitle = checkNotNull(tabTitle);
    }

    /** Get the fragment that this tab will be displaying */
    public Class<? extends Fragment> getTabContentFragment() {
        return mTabContentFragment;
    }

    /** Sets the fragment that this tab will be displaying */
    public void setTabContentFragment(Class<? extends Fragment> tabContentFragment) {
        mTabContentFragment = checkNotNull(tabContentFragment);
    }

    /**
     * Get the resource ID of the icon that will be displayed for this tab.
     * Returns null if one is not set
     */
    public Integer getTabIcon() {
        return mTabIcon;
    }

    /**
     * Set the resource ID of the icon to be displayed for this tab.
     * Null may be set if an icon should not be set
     */
    public void setTabIcon(Integer tabIcon) {
        mTabIcon = tabIcon;
    }


    public ActionBar.TabListener getTabListener() {
        return mTabListener;
    }

    public void setTabListener(SupportTabListener supportTabListener) {
        mTabListener = supportTabListener;
    }
}