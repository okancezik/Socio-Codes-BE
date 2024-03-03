package com.okancezik.tubitak.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostUploadRequest {

    @NotNull
    @NotBlank
    private int userId;

    @NotNull
    @NotBlank
    private String content;

    @NotNull
    @NotBlank
    private String repositoryUrl;

    @NotNull
    @NotBlank
    private String repositoryStarCount;

    @NotNull
    @NotBlank
    private String repositoryForkCount;

    @NotNull
    @NotBlank
    private String repositoryUpdatedDate;

    @NotNull
    @NotBlank
    private String repositoryDescription;

    @NotNull
    @NotBlank
    private int branchId;

}
