package com.okancezik.tubitak.business.abstracts;

import com.okancezik.tubitak.business.dtos.requests.UserUpdateGithubInfoRequest;
import com.okancezik.tubitak.core.results.Result;

public interface GitHubService {
    Result save(UserUpdateGithubInfoRequest userGithub);
}
