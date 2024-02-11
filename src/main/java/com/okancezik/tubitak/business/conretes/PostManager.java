package com.okancezik.tubitak.business.conretes;

import com.okancezik.tubitak.business.abstracts.PostService;
import com.okancezik.tubitak.business.dtos.requests.PostUploadRequest;
import com.okancezik.tubitak.business.dtos.responses.PostListModelResponse;
import com.okancezik.tubitak.core.results.*;
import com.okancezik.tubitak.core.utils.mappers.ModelMapperService;
import com.okancezik.tubitak.dataAccess.PostRepository;
import com.okancezik.tubitak.entity.concretes.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostManager implements PostService {

    private final PostRepository repository;
    private final ModelMapperService mapper;

    @Override
    public Result save(PostUploadRequest postUploadRequest) {
        Post post = mapper.forRequest().map(postUploadRequest, Post.class);
        repository.save(post);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<PostListModelResponse>> getAll() {
        List<Post> posts = repository.findAll();
        List<PostListModelResponse> listedPosts =
                posts.stream().map(post -> mapper.forResponse().map(post, PostListModelResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(listedPosts, "Listed posts");
    }
}
