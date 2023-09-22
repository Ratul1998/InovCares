package com.app.health;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

public abstract class BaseActivity<VB extends ViewBinding> extends AppCompatActivity {

    protected VB binding;

    protected TextView mTextViewScreenTitle;
    protected ImageView mImageButtonBack;

    protected FrameLayout progressLayout;

    protected ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewBinding();
        setContentView(binding.getRoot());
    }

    @Override
    public void setContentView(View view) {
        ConstraintLayout coordinatorLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout activityContainer = coordinatorLayout.findViewById(R.id.inflaterLayout);
        mTextViewScreenTitle = coordinatorLayout.findViewById(R.id.screenTitle);
        mImageButtonBack = coordinatorLayout.findViewById(R.id.backButton);
        progressLayout = coordinatorLayout.findViewById(R.id.progressLayout);
        progressBar = coordinatorLayout.findViewById(R.id.loaderProgressBar);
        activityContainer.addView(view);
        super.setContentView(coordinatorLayout);
    }

    public void setScreenTitle(int resId) {
        mTextViewScreenTitle.setText(getString(resId));
    }
    public void setScreenTitle(String title) {
        mTextViewScreenTitle.setText(title);
    }
    public ImageView getBackButton() {
        return mImageButtonBack;
    }

    protected abstract VB getViewBinding();
}