package com.okancezik.tubitak.business.conretes;

import com.okancezik.tubitak.business.abstracts.GitHubService;
import com.okancezik.tubitak.business.dtos.requests.UserUpdateGithubInfoRequest;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.core.results.Result;
import com.okancezik.tubitak.core.results.SuccessDataResult;
import com.okancezik.tubitak.core.results.SuccessResult;
import com.okancezik.tubitak.core.utils.mappers.ModelMapperService;
import com.okancezik.tubitak.dataAccess.GitHubProfileRepository;
import com.okancezik.tubitak.entity.concretes.GitHubProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GitHubManager implements GitHubService {

    private final GitHubProfileRepository repository;
    private final ModelMapperService mapper;

    @Override
    public Result save(UserUpdateGithubInfoRequest userGithub) {
        GitHubProfile gitHubProfile = mapper.forRequest().map(userGithub, GitHubProfile.class);
        repository.save(gitHubProfile);
        return new SuccessResult("Updated successfully");
    }
}
