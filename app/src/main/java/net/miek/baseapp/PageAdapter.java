package net.miek.baseapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Mike Wang on 2015/11/12.
 */
public class PageAdapter extends FragmentPagerAdapter {
    private int mSize;

    public PageAdapter(FragmentManager fm, int size) {
        super(fm);
        mSize = size;
    }

    @Override
    public Fragment getItem(int position) {
        PageFragment page = new PageFragment();
        Bundle arg = new Bundle();
        arg.putString("page_info", "Page " + position);
        page.setArguments(arg);

        return page;
    }

    @Override
    public int getCount() {
        return mSize;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab Title ["+position+"]";
    }
}
