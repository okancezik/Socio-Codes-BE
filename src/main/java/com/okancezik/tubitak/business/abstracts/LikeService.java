package com.okancezik.tubitak.business.abstracts;

import com.okancezik.tubitak.business.dtos.requests.LikePostRequest;
import com.okancezik.tubitak.core.results.Result;

public interface LikeService {
    Result likeThePost(LikePostRequest like);
    Result unLikeThePost(LikePostRequest like);
}
