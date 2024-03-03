package com.okancezik.tubitak.api;

import com.okancezik.tubitak.business.abstracts.LikeService;
import com.okancezik.tubitak.business.dtos.requests.LikePostRequest;
import com.okancezik.tubitak.core.results.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/like")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService service;

    @PostMapping
    public Result likeThePost(@RequestBody LikePostRequest like){
        return service.likeThePost(like);
    }
    @DeleteMapping
    public Result unLikeThePost(@RequestBody LikePostRequest like){
        return service.unLikeThePost(like);
    }

}
