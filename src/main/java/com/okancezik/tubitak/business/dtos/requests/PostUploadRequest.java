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
    private String imageUrl;

    @NotNull
    @NotBlank
    private String repositoryUrl;

}
