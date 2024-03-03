package com.okancezik.tubitak.api;

import com.okancezik.tubitak.business.abstracts.GitHubService;
import com.okancezik.tubitak.business.dtos.requests.UserUpdateGithubInfoRequest;
import com.okancezik.tubitak.core.results.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/github-profile")
@RequiredArgsConstructor
public class GitHubProfileController {
    private final GitHubService service;

    @PostMapping
    public Result save(@RequestBody UserUpdateGithubInfoRequest user) {
        return service.save(user);
    }
}
