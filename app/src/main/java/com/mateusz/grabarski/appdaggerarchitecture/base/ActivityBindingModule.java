package com.mateusz.grabarski.appdaggerarchitecture.base;

import android.app.Activity;

import com.mateusz.grabarski.appdaggerarchitecture.views.Home.MainActivity;
import com.mateusz.grabarski.appdaggerarchitecture.views.Home.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Mateusz Grabarski on 09.02.2018.
 */
@Module(subcomponents = {
        MainActivityComponent.class
})
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> provideMainActivity(MainActivityComponent.Builder builder);
}
