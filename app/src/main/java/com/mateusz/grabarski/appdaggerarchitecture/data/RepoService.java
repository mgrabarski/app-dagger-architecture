package com.mateusz.grabarski.appdaggerarchitecture.data;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Mateusz Grabarski on 21.02.2018.
 */

public interface RepoService {

    @GET("")
    Single<TrendingReposResponse> getTrendingRepos();
}
