package com.okancezik.tubitak.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentListModelResponse {

    private String comment;
    private int postId;
    private int userId;
    private String userFullName;
    private String userAvatarUrl;
}
