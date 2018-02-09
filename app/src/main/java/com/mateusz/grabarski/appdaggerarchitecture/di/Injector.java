package com.mateusz.grabarski.appdaggerarchitecture.di;

import android.app.Activity;

import com.mateusz.grabarski.appdaggerarchitecture.base.BaseActivity;

/**
 * Created by Mateusz Grabarski on 09.02.2018.
 */

public class Injector {

    private Injector() {

    }

    public static void inject(Activity activity) {
        ActivityInjector.get(activity).inject(activity);
    }


    public static void clearComponent(Activity activity) {
        ActivityInjector.get(activity).clear(activity);
    }
}
