package com.mateusz.grabarski.appdaggerarchitecture.base;

import android.app.Application;

import com.mateusz.grabarski.appdaggerarchitecture.di.ActivityInjector;

import javax.inject.Inject;

/**
 * Created by Mateusz Grabarski on 09.02.2018.
 */

public class App extends Application {

    @Inject
    ActivityInjector activityInjector;

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mComponent.inject(this);
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
