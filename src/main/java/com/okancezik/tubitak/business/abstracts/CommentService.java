package com.okancezik.tubitak.business.abstracts;

import com.okancezik.tubitak.business.dtos.requests.CommentUploadRequest;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.entity.concretes.Comment;

public interface CommentService {
    DataResult<Comment> upload(CommentUploadRequest request);
}
