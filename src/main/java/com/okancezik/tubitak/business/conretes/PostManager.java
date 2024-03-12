package com.okancezik.tubitak.business.conretes;

import com.okancezik.tubitak.business.abstracts.PostService;
import com.okancezik.tubitak.business.dtos.requests.PostUploadRequest;
import com.okancezik.tubitak.business.dtos.responses.PostListModelResponse;
import com.okancezik.tubitak.core.filter_pagination.PostPaginationFiltering;
import com.okancezik.tubitak.core.results.*;
import com.okancezik.tubitak.core.utils.mappers.ModelMapperService;
import com.okancezik.tubitak.dataAccess.LikeRepository;
import com.okancezik.tubitak.dataAccess.PostRepository;
import com.okancezik.tubitak.entity.concretes.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostManager implements PostService {

    private final PostRepository repository;
    private final LikeRepository likeRepository;
    private final ModelMapperService mapper;

    @Override
    public Result save(PostUploadRequest postUploadRequest) {
        Post post = mapper.forRequest().map(postUploadRequest, Post.class);
        repository.save(post);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<PostListModelResponse>> getAll(PostPaginationFiltering pagination, int userId) {
        Page<Post> posts = repository.findAll(
                PageRequest.of(pagination.getPageIndex(), pagination.getPageSize())
        );

        List<PostListModelResponse> postData = new ArrayList<>();

        for (Post post: posts) {
            boolean liked=false;
            liked = likeRepository.findByPost_IdAndUser_Id(post.getId(),userId).isPresent();
            postData.add(new PostListModelResponse(
                    post.getUser().getId(),
                    post.getId(),
                    post.getUser().getFullName(),
                    post.getUser().getAvatarUrl(),
                    post.getContent(),
                    post.getRepositoryUrl(),
                    post.getLoadDate(),
                    post.getCommentCount(),
                    post.getLikeCount(),
                    post.getRepositoryDescription(),
                    post.getRepositoryUpdatedDate(),
                    post.getRepositoryForkCount(),
                    post.getRepositoryStarCount(),
                    "post.getBranch().getName()",
                    liked
            ));
        }

        return new SuccessDataResult<>(postData, "Listed posts");
    }

    @Override
    public DataResult<List<PostListModelResponse>> getAllByBranchId(PostPaginationFiltering pagination, int branchId,int userId) {
        List<Post> posts = repository.findAllPostByBranchId(
                PageRequest.of(pagination.getPageIndex(), pagination.getPageSize()), branchId
        );

        List<PostListModelResponse> postData = new ArrayList<>();

        for (Post post : posts) {
            boolean liked = false;
            liked = likeRepository.findByPost_IdAndUser_Id(post.getId(), userId).isPresent();
            postData.add(new PostListModelResponse(
                    post.getUser().getId(),
                    post.getId(),
                    post.getUser().getFullName(),
                    post.getUser().getAvatarUrl(),
                    post.getContent(),
                    post.getRepositoryUrl(),
                    post.getLoadDate(),
                    post.getCommentCount(),
                    post.getLikeCount(),
                    post.getRepositoryDescription(),
                    post.getRepositoryUpdatedDate(),
                    post.getRepositoryForkCount(),
                    post.getRepositoryStarCount(),
                    "post.getBranch().getName()",
                    liked
            ));
        }
        return new SuccessDataResult<>(postData, "Listed posts");
    }

    @Override
    public DataResult<List<PostListModelResponse>> getAllByStudentId(PostPaginationFiltering pagination, int studentId) {
        List<Post> posts = repository.findAllPostByUserId(PageRequest.of(pagination.getPageIndex(), pagination.getPageSize()), studentId);
        if (posts.size() != 0) {
            List<PostListModelResponse> postListModelResponses = posts.stream().
                    map((post -> mapper.forResponse().map(post, PostListModelResponse.class)))
                    .collect(Collectors.toList());
            return new SuccessDataResult<>(postListModelResponses,"Listed Posts");
        }else {
            return new ErrorDataResult<>("Not found post");
        }

    }

    @Override
    public Result delete(int postId) {
       Optional<Post> post = repository.findById(postId);
       if(post.isPresent()){
           repository.deleteById(postId);
           return new SuccessResult("Deleted post");
       }else{
           return new ErrorResult("Not found post");
       }
    }
}
