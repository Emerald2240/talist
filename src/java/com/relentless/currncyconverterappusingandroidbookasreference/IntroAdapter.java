package com.relentless.currncyconverterappusingandroidbookasreference;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class IntroAdapter extends FragmentPagerAdapter {
    public int getCount() {
        return 4;
    }

    public IntroAdapter(FragmentManager fragmentManager, int i) {
        super(fragmentManager, i);
    }

    public Fragment getItem(int i) {
        if (i == 0) {
            return new FirstFragment();
        }
        if (i == 1) {
            return new SecondFragment();
        }
        if (i != 2) {
            return i != 3 ? null : new FourthFragment();
        } else {
            return new ThirdFragment();
        }
    }
}
