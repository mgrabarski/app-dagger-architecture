package com.mateusz.grabarski.appdaggerarchitecture.data;

import com.mateusz.grabarski.appdaggerarchitecture.model.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Mateusz Grabarski on 21.02.2018.
 */

public class RepoRequester {

    private RepoService repoService;

    @Inject
    public RepoRequester(RepoService repoService) {
        this.repoService = repoService;
    }

    public Single<List<Repo>> getTrendingRepos() {
        return repoService.getTrendingRepos()
                .map(TrendingReposResponse::repos)
                .subscribeOn(Schedulers.io());
    }
}
