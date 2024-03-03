package com.okancezik.tubitak.business.conretes;

import com.okancezik.tubitak.business.abstracts.LikeService;
import com.okancezik.tubitak.business.dtos.requests.LikePostRequest;
import com.okancezik.tubitak.core.results.ErrorResult;
import com.okancezik.tubitak.core.results.Result;
import com.okancezik.tubitak.core.results.SuccessResult;
import com.okancezik.tubitak.core.utils.mappers.ModelMapperService;
import com.okancezik.tubitak.dataAccess.LikeRepository;
import com.okancezik.tubitak.entity.concretes.Like;
import com.okancezik.tubitak.entity.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeManager implements LikeService {

    private final LikeRepository repository;
    private final ModelMapperService mapper;

    @Override
    public Result likeThePost(LikePostRequest like) {
       Like mappedLike = mapper.forRequest().map(like, Like.class);
        repository.save(mappedLike);
        return new SuccessResult("Liked post");
    }

    @Override
    public Result unLikeThePost(LikePostRequest like) {
        Optional<Like> liked = repository.findByPost_IdAndUser_Id(like.getPostId(), like.getUserId());
        if(!liked.isPresent())return new ErrorResult("Not found like");
        else {
            repository.delete(liked.get());
            return new SuccessResult("Deleted like");
        }
    }
}
