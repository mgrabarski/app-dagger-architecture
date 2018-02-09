package com.mateusz.grabarski.appdaggerarchitecture.base;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mateusz Grabarski on 09.02.2018.
 */
@Module
public class ApplicationModule {

    private App mApp;

    public ApplicationModule(App app) {
        this.mApp = app;
    }

    @Provides
    public Context provideApplicationContext() {
        return mApp;
    }
}
