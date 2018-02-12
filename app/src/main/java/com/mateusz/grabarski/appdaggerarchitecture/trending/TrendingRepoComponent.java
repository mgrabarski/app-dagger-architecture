package com.mateusz.grabarski.appdaggerarchitecture.trending;

import dagger.Component;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Mateusz Grabarski on 12.02.2018.
 */
@Component
@Subcomponent
public interface TrendingRepoComponent extends AndroidInjector<TrendingRepoComponent> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrendingReposController> {
        
    }
}
