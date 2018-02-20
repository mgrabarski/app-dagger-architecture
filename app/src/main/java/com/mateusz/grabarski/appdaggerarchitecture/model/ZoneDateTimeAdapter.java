package com.mateusz.grabarski.appdaggerarchitecture.model;

import android.support.annotation.Nullable;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import org.threeten.bp.ZonedDateTime;

/**
 * Created by MGrabarski on 20.02.2018.
 */

public class ZoneDateTimeAdapter {

    @FromJson
    ZonedDateTime fromJson(String json) {
        return ZonedDateTime.parse(json);
    }

    @ToJson
    String toJson(@Nullable ZonedDateTime value) {
        return value != null ? value.toString() : null;
    }
}
