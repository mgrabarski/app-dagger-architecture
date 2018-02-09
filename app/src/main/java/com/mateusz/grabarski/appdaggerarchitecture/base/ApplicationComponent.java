package com.mateusz.grabarski.appdaggerarchitecture.base;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Mateusz Grabarski on 09.02.2018.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class
})
public interface ApplicationComponent {

    void inject(App app);
}
