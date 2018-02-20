package com.mateusz.grabarski.appdaggerarchitecture.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

/**
 * Created by MGrabarski on 20.02.2018.
 */

public interface ScreenNavigator {
    void initWithRoute(Router route, Controller roomScreen);
    boolean pop();
    void clear();
}
