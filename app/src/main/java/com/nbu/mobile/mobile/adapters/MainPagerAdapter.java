package com.nbu.mobile.mobile.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nbu.mobile.common.base.BaseFragment;

import java.util.HashMap;

/**
 * Created by Sarvar on 04.09.2017.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private HashMap<Integer,BaseFragment> pagers;

    public MainPagerAdapter(FragmentManager fm,HashMap<Integer,BaseFragment> pagers) {
        super(fm);
        this.pagers = pagers;
    }

    @Override
    public Fragment getItem(int position) {
        return pagers.get(position);
    }

    @Override
    public int getCount() {
        return pagers.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pagers.get(position).getTitle();
    }
}
