package com.mateusz.grabarski.appdaggerarchitecture.views.Home;

import android.os.Bundle;

import com.mateusz.grabarski.appdaggerarchitecture.R;
import com.mateusz.grabarski.appdaggerarchitecture.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
