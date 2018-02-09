package com.mateusz.grabarski.appdaggerarchitecture.views.Home;

import com.mateusz.grabarski.appdaggerarchitecture.di.scopes.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;

/**
 * Created by Mateusz Grabarski on 09.02.2018.
 */
@ActivityScope
@Subcomponent
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
        
    }
}
