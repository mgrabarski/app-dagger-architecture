package com.mateusz.grabarski.appdaggerarchitecture.di;

import android.app.Activity;
import android.content.Context;

import com.mateusz.grabarski.appdaggerarchitecture.base.App;
import com.mateusz.grabarski.appdaggerarchitecture.base.BaseActivity;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;

/**
 * Created by Mateusz Grabarski on 09.02.2018.
 */

public class ActivityInjector {

    private Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> mActivityInjectors;
    private final Map<String, AndroidInjector<? extends Activity>> cache = new HashMap<>();

    @Inject
    public ActivityInjector(Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors) {
        this.mActivityInjectors = activityInjectors;
    }

    void inject(Activity activity) {
        if (!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException("Activity must extend BaseActivity");
        }

        String instanceId = ((BaseActivity) activity).getInstanceId();

        if (cache.containsKey(instanceId)) {
            //noinspection unchecked
            ((AndroidInjector<Activity>) cache.get(instanceId)).inject(activity);
            return;
        }

        //noinspection unchecked
        AndroidInjector.Factory<Activity> injectorFactory =
                (AndroidInjector.Factory<Activity>) mActivityInjectors.get(activity.getClass()).get();

        AndroidInjector<Activity> injector = injectorFactory.create(activity);

        cache.put(instanceId, injector);

        injector.inject(activity);
    }

    void clear(Activity activity) {
        if (!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException("Activity must extend BaseActivity");
        }

        cache.remove(((BaseActivity) activity).getInstanceId());
    }

    static ActivityInjector get(Context context) {
        return ((App) context.getApplicationContext()).getActivityInjector();
    }
}
