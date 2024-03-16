package com.okancezik.tubitak.api;

import com.okancezik.tubitak.business.abstracts.GitHubService;
import com.okancezik.tubitak.business.dtos.requests.UserUpdateGithubInfoRequest;
import com.okancezik.tubitak.core.results.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/github-profile")
@RequiredArgsConstructor
@Tag(name = "GitHubProfile")
public class GitHubProfileController {
    private final GitHubService service;

    @Operation(
            description = "GitHub profile upload endpoint",
            summary = "GitHub profile upload",
            responses = {
                    @ApiResponse(
                            description = "Created",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @PostMapping
    public Result save(@RequestBody UserUpdateGithubInfoRequest user) {
        return service.save(user);
    }
}
