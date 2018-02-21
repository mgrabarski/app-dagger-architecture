package com.mateusz.grabarski.appdaggerarchitecture.data;

import com.google.auto.value.AutoValue;
import com.mateusz.grabarski.appdaggerarchitecture.model.Repo;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

/**
 * Created by Mateusz Grabarski on 21.02.2018.
 */
@AutoValue
public abstract class TrendingReposResponse {

    @Json(name = "items")
    public abstract List<Repo> repos();

    public static JsonAdapter<TrendingReposResponse> jsonAdapter(Moshi moshi) {
        return new AutoValue_TrendingReposResponse.MoshiJsonAdapter(moshi);
    }
}
