package com.droid.ankit.udacityrolodex;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.droid.ankit.udacityrolodex.data.UserData;

import java.util.List;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private List<RolodexPageFragment> mUserFragments;

    public ScreenSlidePagerAdapter(List<RolodexPageFragment> userFragments, FragmentManager fm) {
        super(fm);
        this.mUserFragments = userFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mUserFragments.get(position);
    }

    @Override
    public int getCount() {
        return mUserFragments.size();
    }
}