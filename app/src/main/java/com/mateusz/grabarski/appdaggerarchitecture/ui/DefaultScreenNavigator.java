package com.mateusz.grabarski.appdaggerarchitecture.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.mateusz.grabarski.appdaggerarchitecture.di.scopes.ActivityScope;

import javax.inject.Inject;

/**
 * Created by MGrabarski on 20.02.2018.
 */
@ActivityScope
public class DefaultScreenNavigator implements ScreenNavigator {

    private Router router;

    @Inject
    public DefaultScreenNavigator() {
    }

    @Override
    public void initWithRoute(Router router, Controller roomScreen) {
        this.router = router;

        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(roomScreen));
        }
    }

    @Override
    public boolean pop() {
        return router != null && router.handleBack();
    }

    @Override
    public void clear() {
        router = null;
    }
}
