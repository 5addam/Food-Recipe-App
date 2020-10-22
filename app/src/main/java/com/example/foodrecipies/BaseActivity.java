package com.example.foodrecipies;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

//we'll be extending all activites using this base activity instead of AppCompactActivity
public abstract class BaseActivity extends AppCompatActivity {
    public ProgressBar progressBar;

    @Override
    public void setContentView(int layoutResID) {
        ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_base,null); //our main layout for base activity
        FrameLayout frameLayout = constraintLayout.findViewById(R.id.activity_content); // framelayout is going to act as a container for any activity that extends base activity
        progressBar = constraintLayout.findViewById(R.id.progressBar);

        getLayoutInflater().inflate(layoutResID,frameLayout,true);

        super.setContentView(constraintLayout);
    }

    public void showProgressBar(boolean visibility){
        progressBar.setVisibility(visibility ? View.VISIBLE : View.INVISIBLE);
    }
}
