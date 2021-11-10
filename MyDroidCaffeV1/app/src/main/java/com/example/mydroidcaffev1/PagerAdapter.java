package com.example.mydroidcaffev1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int myNumberOfTabs;
    public PagerAdapter(@NonNull @org.jetbrains.annotations.NotNull FragmentManager fm, int numOfTabs) {
        super(fm, numOfTabs);
        this.myNumberOfTabs=numOfTabs;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new DessertRecipeFragment();
            case 1: return new PastriesRecipeFragment();
            case 2: return new StoresFragment();
            default: return null;
        }

    }

    @Override
    public int getCount() {
        return myNumberOfTabs;
    }
}
