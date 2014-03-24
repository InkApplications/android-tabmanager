package com.inkapplications.tabmanager;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Build;

import static com.inkapplications.tabmanager.Preconditions.checkNotNull;

/** Class containing all information needed to construct a tab */
public class TabContent {

    private Integer tabIcon;
    private String tabTitle;
    private Class<? extends Fragment> tabContentFragment;
    private ActionBar.TabListener tabListener;

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
     * constructors and they all just route here.  DefaultTabListener and FragmentListener can not both be
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
        this.tabTitle = checkNotNull(tabTitle);
        this.tabContentFragment = tabContentFragment;
        this.tabIcon = tabIcon;
        this.tabListener = tabListener;
    }

    public String getTabTitle() {
        return tabTitle;
    }

    public void setTabTitle(String tabTitle) {
        this.tabTitle = checkNotNull(tabTitle);
    }

    public Class<? extends Fragment> getTabContentFragment() {
        return tabContentFragment;
    }

    public void setTabContentFragment(Class<? extends Fragment> tabContentFragment) {
        this.tabContentFragment = checkNotNull(tabContentFragment);
    }

    public Integer getTabIcon() {
        return tabIcon;
    }

    public void setTabIcon(Integer tabIcon) {
        this.tabIcon = tabIcon;
    }

    public ActionBar.TabListener getTabListener() {
        return tabListener;
    }

    public void setTabListener(DefaultTabListener defaultTabListener) {
        tabListener = defaultTabListener;
    }
}
