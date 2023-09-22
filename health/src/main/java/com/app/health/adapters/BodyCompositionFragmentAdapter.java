package com.app.health.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.health.fragments.ActivityLevelFragment;
import com.app.health.fragments.BodyWeightFragment;
import com.app.health.fragments.RiskFactorFragment;
import com.app.health.fragments.SelfHealthFragment;

public class BodyCompositionFragmentAdapter extends FragmentStateAdapter {

    public BodyCompositionFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if(position == 0){
            return new RiskFactorFragment();
        }

        if(position == 2){
            return new ActivityLevelFragment();
        }

        if(position == 3){
            return new BodyWeightFragment();
        }

        return new SelfHealthFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
