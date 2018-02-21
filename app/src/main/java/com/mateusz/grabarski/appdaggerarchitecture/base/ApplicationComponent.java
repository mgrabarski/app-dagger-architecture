package com.mateusz.grabarski.appdaggerarchitecture.base;

import com.mateusz.grabarski.appdaggerarchitecture.data.RepoServiceModule;
import com.mateusz.grabarski.appdaggerarchitecture.network.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Mateusz Grabarski on 09.02.2018.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class
})
public interface ApplicationComponent {

    void inject(App app);
}
