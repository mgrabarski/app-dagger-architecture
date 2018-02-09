package com.mateusz.grabarski.appdaggerarchitecture.base;

import android.app.Application;

/**
 * Created by Mateusz Grabarski on 09.02.2018.
 */

public class App extends Application {

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
