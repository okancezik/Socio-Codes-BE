package com.okancezik.tubitak.api;

import com.okancezik.tubitak.business.abstracts.CommentService;
import com.okancezik.tubitak.business.dtos.requests.CommentUploadRequest;
import com.okancezik.tubitak.core.results.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController {

    private final CommentService service;

    @PostMapping
    public Result upload(@RequestBody CommentUploadRequest request){
        return service.upload(request);
    }

    @GetMapping
    public Result getCommentsByPostId(@RequestParam int postId){
        return service.getCommentsByPostId(postId);
    }
}
