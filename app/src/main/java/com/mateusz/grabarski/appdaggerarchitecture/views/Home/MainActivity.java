package com.mateusz.grabarski.appdaggerarchitecture.views.Home;

import com.bluelinelabs.conductor.Controller;
import com.mateusz.grabarski.appdaggerarchitecture.R;
import com.mateusz.grabarski.appdaggerarchitecture.base.BaseActivity;
import com.mateusz.grabarski.appdaggerarchitecture.trending.TrendingReposController;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingReposController();
    }
}
