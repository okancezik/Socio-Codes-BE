package com.okancezik.tubitak.business.conretes;

import com.okancezik.tubitak.business.abstracts.PostService;
import com.okancezik.tubitak.dataAccess.PostRepository;
import com.okancezik.tubitak.entity.concretes.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostManager implements PostService {

    private final PostRepository repository;
    @Override
    public void save(Post post) {
        repository.save(post);
    }
}
