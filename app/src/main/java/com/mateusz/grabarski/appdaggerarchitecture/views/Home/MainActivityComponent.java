package com.mateusz.grabarski.appdaggerarchitecture.views.Home;

import com.mateusz.grabarski.appdaggerarchitecture.di.scopes.ActivityScope;
import com.mateusz.grabarski.appdaggerarchitecture.ui.NavigationModule;
import com.mateusz.grabarski.appdaggerarchitecture.views.di.MainScreenBindingModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Mateusz Grabarski on 09.02.2018.
 */
@ActivityScope
@Subcomponent(modules = {
        MainScreenBindingModule.class,
        NavigationModule.class
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

        @Override
        public void seedInstance(MainActivity instance) {

        }
    }
}
