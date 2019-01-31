package com.aiub.worldcup2018androidsix.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.aiub.worldcup2018androidsix.ViewPagerFragments.MatchesFragment;
import com.aiub.worldcup2018androidsix.ViewPagerFragments.TablesFragment;

public class GroupDetailsFragmentPagerAdapter extends FragmentPagerAdapter {

    public GroupDetailsFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MatchesFragment();
            case 1:
                return new TablesFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Matches";
            case 1:
                return "Tables";
        }
        return super.getPageTitle(position);
    }
}
