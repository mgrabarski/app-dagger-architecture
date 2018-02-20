package com.mateusz.grabarski.appdaggerarchitecture.trending;

import com.mateusz.grabarski.appdaggerarchitecture.di.scopes.ScreenScope;

import dagger.Component;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Mateusz Grabarski on 12.02.2018.
 */
@ScreenScope
@Subcomponent
public interface TrendingRepoComponent extends AndroidInjector<TrendingReposController> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrendingReposController> {
        
    }
}
