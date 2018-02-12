package com.mateusz.grabarski.appdaggerarchitecture.base;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.mateusz.grabarski.appdaggerarchitecture.di.Injector;

/**
 * Created by Mateusz Grabarski on 12.02.2018.
 */

public abstract class BaseController extends Controller {

    private boolean injected = false;

    @Override
    protected void onContextAvailable(@NonNull Context context) {
        if (!injected) {
            Injector.inject(this);
            injected = true;
        }

        super.onContextAvailable(context);
    }
}
