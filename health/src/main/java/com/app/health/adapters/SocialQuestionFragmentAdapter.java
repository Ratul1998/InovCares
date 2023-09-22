package com.app.health.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.health.fragments.SocialQuestionFragment;
import com.app.health.model.SocialQuestionModel;

import java.util.List;


public class SocialQuestionFragmentAdapter extends FragmentStateAdapter {

    final List<SocialQuestionModel> questions;

    public SocialQuestionFragmentAdapter(@NonNull FragmentActivity fragmentActivity,List<SocialQuestionModel> questions) {
        super(fragmentActivity);
        this.questions = questions;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return SocialQuestionFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
