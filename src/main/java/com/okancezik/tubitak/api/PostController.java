package com.okancezik.tubitak.api;

import com.okancezik.tubitak.business.abstracts.PostService;
import com.okancezik.tubitak.business.dtos.requests.PostUploadRequest;
import com.okancezik.tubitak.business.dtos.responses.PostListModelResponse;
import com.okancezik.tubitak.core.filter_pagination.PostPaginationFiltering;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.core.results.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService service;

    @PostMapping
    public Result save(@RequestBody PostUploadRequest post){
        return service.save(post);
    }

    @PostMapping("/list")
    public DataResult<List<PostListModelResponse>> getAll(
            @RequestBody PostPaginationFiltering pagination,
            @RequestParam(required = false) Integer branchId
    ){
        if(branchId != null)
            return service.getAllByBranchId(pagination,branchId);
        else
            return service.getAll(pagination);
    }

    @PostMapping("/list/student/{studentId}")
    public DataResult<List<PostListModelResponse>> getAll(
            @RequestBody PostPaginationFiltering pagination, @PathVariable int studentId
    )
    {
        return service.getAllByStudentId(pagination, studentId);
    }
}
