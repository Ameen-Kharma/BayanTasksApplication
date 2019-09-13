package com.tasks.android.bayantasksapplication;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;

/**
 * Created by Ameen_Kharma on 9/13/2019.
 */

public class TabsAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public TabsAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MyTasksFragment myTasksFragment = new MyTasksFragment();
                return myTasksFragment;
            case 1:
                MyTasksFragment myTeamFragmet = new MyTasksFragment();
                return myTeamFragmet;
            default:
                return null;
        }    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
