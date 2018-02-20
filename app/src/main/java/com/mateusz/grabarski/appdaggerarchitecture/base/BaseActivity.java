package com.mateusz.grabarski.appdaggerarchitecture.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.Router;
import com.mateusz.grabarski.appdaggerarchitecture.R;
import com.mateusz.grabarski.appdaggerarchitecture.di.Injector;
import com.mateusz.grabarski.appdaggerarchitecture.di.ScreenInjector;
import com.mateusz.grabarski.appdaggerarchitecture.ui.ScreenNavigator;

import java.util.UUID;

import javax.inject.Inject;

/**
 * Created by Mateusz Grabarski on 09.02.2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private static String INSTANCE_ID_KEY = "instance_id";

    @Inject
    ScreenInjector screenInjector;

    @Inject
    ScreenNavigator screenNavigator;

    private String mInstanceId;
    private Router router;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            mInstanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
        } else {
            mInstanceId = UUID.randomUUID().toString();
        }

        Injector.inject(this);
        setContentView(layoutRes());

        ViewGroup screenContainer = findViewById(R.id.screen_container);
        if (screenContainer == null)
            throw new NullPointerException("Activity must have view with id: screen_container");

        router = Conductor.attachRouter(this, screenContainer, savedInstanceState);

        screenNavigator.initWithRoute(router, initialScreen());

        monitorBackStack();

        super.onCreate(savedInstanceState);
    }

    @LayoutRes
    protected abstract int layoutRes();

    protected abstract Controller initialScreen();

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(INSTANCE_ID_KEY, mInstanceId);
    }

    @Override
    public void onBackPressed() {
        if (!screenNavigator.pop()) {
            super.onBackPressed();
        }
    }

    public String getInstanceId() {
        return mInstanceId;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        screenNavigator.clear();

        if (isFinishing()) {
            Injector.clearComponent(this);
        }
    }

    public ScreenInjector getScreenInjector() {
        return screenInjector;
    }

    private void monitorBackStack() {
        router.addChangeListener(new ControllerChangeHandler.ControllerChangeListener() {
            @Override
            public void onChangeStarted(
                    @Nullable Controller to,
                    @Nullable Controller from,
                    boolean isPush,
                    @NonNull ViewGroup container,
                    @NonNull ControllerChangeHandler handler) {

            }

            @Override
            public void onChangeCompleted(
                    @Nullable Controller to,
                    @Nullable Controller from,
                    boolean isPush,
                    @NonNull ViewGroup container,
                    @NonNull ControllerChangeHandler handler) {

                if (!isPush && from != null) {
                    Injector.cleanComponent(from);
                }
            }
        });
    }
}
