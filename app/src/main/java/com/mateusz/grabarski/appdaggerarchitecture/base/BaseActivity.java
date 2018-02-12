package com.mateusz.grabarski.appdaggerarchitecture.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mateusz.grabarski.appdaggerarchitecture.di.Injector;
import com.mateusz.grabarski.appdaggerarchitecture.di.ScreenInjector;

import java.util.UUID;

import javax.inject.Inject;

/**
 * Created by Mateusz Grabarski on 09.02.2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private static String INSTANCE_ID_KEY = "instance_id";

    @Inject
    ScreenInjector screenInjector;

    private String mInstanceId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            mInstanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
        } else {
            mInstanceId = UUID.randomUUID().toString();
        }

        Injector.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(INSTANCE_ID_KEY, mInstanceId);
    }

    public String getInstanceId() {
        return mInstanceId;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (isFinishing()) {
            Injector.clearComponent(this);
        }
    }

    public ScreenInjector getScreenInjector() {
        return screenInjector;
    }
}
