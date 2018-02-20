package com.mateusz.grabarski.appdaggerarchitecture.model;

import com.ryanharter.auto.value.moshi.MoshiAdapterFactory;
import com.squareup.moshi.JsonAdapter;

/**
 * Created by MGrabarski on 20.02.2018.
 */
@MoshiAdapterFactory
public abstract class AdapterFactory implements JsonAdapter.Factory {

    public static JsonAdapter.Factory create() {
        return new AutoValueMoshi_AdapterFactory();
    }
}
