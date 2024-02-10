package com.okancezik.tubitak.api;

import com.okancezik.tubitak.dataAccess.PostRepository;
import com.okancezik.tubitak.entity.concretes.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostRepository repository;

    @PostMapping
    public void save(@RequestBody Post post){
        repository.save(post);
    }
}
