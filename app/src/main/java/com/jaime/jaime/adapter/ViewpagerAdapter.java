package com.jaime.jaime.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.jaime.jaime.activity.PageFragment;

import java.util.ArrayList;
import java.util.List;



public class ViewpagerAdapter extends FragmentPagerAdapter {
    String[] titles;
    List<PageFragment> pages = new ArrayList<PageFragment>();


    public ViewpagerAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        this.titles = titles;
        this.pages.add(new PageFragment());
        this.pages.add(new PageFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
}
