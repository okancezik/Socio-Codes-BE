package com.okancezik.tubitak.business.abstracts;

import com.okancezik.tubitak.business.dtos.requests.PostUploadRequest;
import com.okancezik.tubitak.business.dtos.responses.PostListModelResponse;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.core.results.Result;
import com.okancezik.tubitak.entity.concretes.Post;

import java.util.List;

public interface PostService {

   Result save(PostUploadRequest postUploadRequest);

   DataResult<List<PostListModelResponse>> getAll();

}
