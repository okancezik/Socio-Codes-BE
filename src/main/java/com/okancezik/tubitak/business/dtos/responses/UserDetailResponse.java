package com.okancezik.tubitak.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailResponse {
    private int id;
    private String fullName;
    private String title;
    private String avatarUrl;
    private String bio;
    private int point;
    private int followingCount;
    private int followerCount;
    private String githubProfileUrl;
    private String githubGithubUsername;
}
