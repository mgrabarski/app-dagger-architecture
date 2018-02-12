package com.mateusz.grabarski.appdaggerarchitecture.views.di;

import com.bluelinelabs.conductor.Controller;
import com.mateusz.grabarski.appdaggerarchitecture.di.ControllerKey;
import com.mateusz.grabarski.appdaggerarchitecture.trending.TrendingRepoComponent;
import com.mateusz.grabarski.appdaggerarchitecture.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Mateusz Grabarski on 12.02.2018.
 */
@Module(subcomponents = {
        TrendingRepoComponent.class,

})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingRepoComponent.Builder builder);
}
