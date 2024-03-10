package com.okancezik.tubitak.business.abstracts;

import com.okancezik.tubitak.business.dtos.requests.CommentUploadRequest;
import com.okancezik.tubitak.business.dtos.responses.CommentListModelResponse;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.core.results.Result;

import java.util.List;

public interface CommentService {
    Result upload(CommentUploadRequest request);

    DataResult<List<CommentListModelResponse>> getCommentsByPostId(int postId);
}
