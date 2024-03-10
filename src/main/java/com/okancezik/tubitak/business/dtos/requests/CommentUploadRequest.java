package com.okancezik.tubitak.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentUploadRequest {

    @NotNull
    @NotBlank
    private int userId;

    @NotNull
    @NotBlank
    private int postId;

    @NotNull
    @NotBlank
    private String comment;
}
