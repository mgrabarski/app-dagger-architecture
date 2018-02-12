package com.mateusz.grabarski.appdaggerarchitecture.di;

import com.bluelinelabs.conductor.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import dagger.MapKey;

/**
 * Created by Mateusz Grabarski on 12.02.2018.
 */
@MapKey
@Target(ElementType.METHOD)
public @interface ControllerKey {
    Class<? extends Controller> value();
}
