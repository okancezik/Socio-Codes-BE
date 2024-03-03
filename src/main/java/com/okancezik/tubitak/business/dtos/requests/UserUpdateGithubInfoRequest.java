package com.okancezik.tubitak.business.dtos.requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateGithubInfoRequest {
    private int userId;
    private String avatarUrl;
    private String profileUrl;
    private String githubUsername;
}
