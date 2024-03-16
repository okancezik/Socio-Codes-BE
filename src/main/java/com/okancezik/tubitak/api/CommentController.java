package com.okancezik.tubitak.api;

import com.okancezik.tubitak.business.abstracts.CommentService;
import com.okancezik.tubitak.business.dtos.requests.CommentUploadRequest;
import com.okancezik.tubitak.core.results.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
@Tag(name = "Comment")
public class CommentController {

    private final CommentService service;

    @Operation(
            description = "Comment upload endpoint",
            summary = "Comment upload",
            responses = {
                    @ApiResponse(
                            description = "Created",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @PostMapping
    public Result upload(@RequestBody CommentUploadRequest request){
        return service.upload(request);
    }

    @Operation(
            description = "Comment list endpoint",
            summary = "Comment list",
            responses = {
                    @ApiResponse(
                            description = "Listed",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @GetMapping
    public Result getCommentsByPostId(@RequestParam int postId){
        return service.getCommentsByPostId(postId);
    }

    @Operation(
            description = "Comment delete endpoint",
            summary = "Comment delete",
            responses = {
                    @ApiResponse(
                            description = "Deleted",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @DeleteMapping("/{commentId}")
    public Result delete(@PathVariable int commentId){
        return service.delete(commentId);
    }

}
