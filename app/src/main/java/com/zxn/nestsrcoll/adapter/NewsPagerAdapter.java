package com.zxn.nestsrcoll.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zxn.nestsrcoll.frag.NewsSupportPoorFrag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxn on 2019/1/23.
 */
public class NewsPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmets;

    public NewsPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmets = new ArrayList<>();
        mFragmets.add(NewsSupportPoorFrag.newInstance());
        mFragmets.add(NewsSupportPoorFrag.newInstance());
        mFragmets.add(NewsSupportPoorFrag.newInstance());
        //NewsSupportPoorFrag
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmets.get(i);
    }

    @Override
    public int getCount() {
        return mFragmets.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        NewsSupportPoorFrag frag = (NewsSupportPoorFrag) mFragmets.get(position);
        return frag.getPageTitle();
    }
}
