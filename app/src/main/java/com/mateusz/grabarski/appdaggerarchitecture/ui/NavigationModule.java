package com.mateusz.grabarski.appdaggerarchitecture.ui;

import dagger.Binds;
import dagger.Module;

/**
 * Created by MGrabarski on 20.02.2018.
 */
@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator screenNavigator);
}
