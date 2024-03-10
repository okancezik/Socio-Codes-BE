package com.okancezik.tubitak.business.abstracts;

import com.okancezik.tubitak.business.dtos.requests.PostUploadRequest;
import com.okancezik.tubitak.business.dtos.responses.PostListModelResponse;
import com.okancezik.tubitak.core.filter_pagination.PostPaginationFiltering;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.core.results.Result;
import com.okancezik.tubitak.entity.concretes.Post;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {

   Result save(PostUploadRequest postUploadRequest);

   DataResult<List<PostListModelResponse>> getAll(PostPaginationFiltering pagination, int userId);

   DataResult<List<PostListModelResponse>> getAllByBranchId(PostPaginationFiltering pagination, int branchId,int userId);

   DataResult<List<PostListModelResponse>> getAllByStudentId(PostPaginationFiltering pagination, int studentId);




}
