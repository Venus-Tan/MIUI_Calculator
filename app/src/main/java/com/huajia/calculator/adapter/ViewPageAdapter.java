package com.huajia.calculator.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huajia
 * @date: 2023/7/26 22:15
 */

public class ViewPageAdapter extends FragmentStateAdapter {

    private List<Fragment> list = new ArrayList<>();

    public ViewPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle,List<Fragment> list) {
        super(fragmentManager, lifecycle);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list==null ? 0 : list.size();
    }
}
