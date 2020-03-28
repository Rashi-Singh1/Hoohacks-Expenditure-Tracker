package com.example.expendituretracker;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


/**
 * Created by wolfsoft on 10/11/2015.
 */
public class
CategoryPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public CategoryPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Fragment_First tab1 = new Fragment_First();
                return tab1;

            case 1:
                Fragment_First tab2 = new Fragment_First();
                return tab2;


            case 2:
                Fragment_First tab3 = new Fragment_First();
                return tab3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}