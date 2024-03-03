package com.okancezik.tubitak.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostListModelResponse {
    private int userId;
    private String userFullName;
    private String userAvatarUrl;
    private String content;
    private String repositoryUrl;
    private LocalDateTime loadDate = LocalDateTime.now();
    private String imageUrl;
    private int commentCount;
    private int likeCount;
    private String repositoryDescription;
    private String repositoryUpdatedDate;
    private String repositoryForkCount;
    private String repositoryStarCount;
    private String branchName;

}
