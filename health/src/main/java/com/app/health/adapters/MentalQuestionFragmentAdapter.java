package com.app.health.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.health.fragments.MentalQuestionFragment;


public class MentalQuestionFragmentAdapter extends FragmentStateAdapter {

    final  int count;

    public MentalQuestionFragmentAdapter(@NonNull FragmentActivity fragmentActivity,int count) {
        super(fragmentActivity);
        this.count = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return MentalQuestionFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return count;
    }
}
