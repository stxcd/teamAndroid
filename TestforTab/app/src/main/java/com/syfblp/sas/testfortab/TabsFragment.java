package com.syfblp.sas.testfortab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.syfblp.sas.testfortab.directory.*;
import com.syfblp.sas.testfortab.function.FunctionFilter;
import com.syfblp.sas.testfortab.location.LocationFilter;

/**
 * Created by 212464350 on 12/9/2015.
 */
public class TabsFragment extends Fragment {
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    public static TabsFragment newInstance() {
        TabsFragment fragment = new TabsFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup
                             container,Bundle onInstanceSavedState){
        View rootview= layoutInflater.inflate(R.layout.tab_layout,container,false);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) rootview.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) rootview.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        return rootview;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return DirectoryFragment.newInstance();
                case 1:
                    return LocationFilter.newInstance();
                case 2:
                    return FunctionFilter.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Name";
                case 1:
                    return "Location";
                case 2:
                    return "Function";
            }
            return null;
        }
    }
}


