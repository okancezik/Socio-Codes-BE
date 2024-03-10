package com.okancezik.tubitak.api;

import com.okancezik.tubitak.business.abstracts.CommentService;
import com.okancezik.tubitak.business.dtos.requests.CommentUploadRequest;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.entity.concretes.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController {

    private final CommentService service;

    @PostMapping
    public DataResult<Comment> upload(@RequestBody CommentUploadRequest request){
        return service.upload(request);
    }
}
