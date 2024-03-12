package com.okancezik.tubitak.api;

import com.okancezik.tubitak.business.abstracts.PostService;
import com.okancezik.tubitak.business.dtos.requests.PostUploadRequest;
import com.okancezik.tubitak.business.dtos.responses.PostListModelResponse;
import com.okancezik.tubitak.core.filter_pagination.PostPaginationFiltering;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.core.results.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
@Tag(name = "Post")
public class PostController {

    private final PostService service;

    @Operation(
            description = "Post upload endpoint",
            summary = "Post upload",
            responses = {
                    @ApiResponse(
                            description = "created",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @PostMapping
    public Result save(@RequestBody PostUploadRequest post){
        return service.save(post);
    }

    @PostMapping("/list")
    public DataResult<List<PostListModelResponse>> getAll(
            @RequestBody PostPaginationFiltering pagination,
            @RequestParam(required = false) Integer branchId,
            @RequestParam int userId

    ){
        if(branchId != null)
            return service.getAllByBranchId(pagination,branchId,userId);
        else
            return service.getAll(pagination,userId);
    }

    @PostMapping("/list/student/{studentId}")
    public DataResult<List<PostListModelResponse>> getAll(
            @RequestBody PostPaginationFiltering pagination, @PathVariable int studentId
    )
    {
        return service.getAllByStudentId(pagination, studentId);
    }

    @DeleteMapping("/{postId}")
    public Result delete(@PathVariable int postId){
        return service.delete(postId);
    }
}
