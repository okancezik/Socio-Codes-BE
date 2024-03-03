package com.okancezik.tubitak.business.abstracts;

import com.okancezik.tubitak.business.dtos.requests.UserRegisterRequest;
import com.okancezik.tubitak.business.dtos.requests.UserUpdateGithubInfoRequest;
import com.okancezik.tubitak.business.dtos.requests.UserUpdateInfoRequest;
import com.okancezik.tubitak.business.dtos.responses.UserDetailResponse;
import com.okancezik.tubitak.business.dtos.responses.UserScoreModelResponse;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.core.results.Result;
import com.okancezik.tubitak.entity.concretes.User;

import java.util.List;

public interface UserService {
    Result save(UserRegisterRequest user);

    DataResult<List<UserScoreModelResponse>> getUserScoreList();

    DataResult<UserDetailResponse> getUserDetailById(int id);

    DataResult<UserDetailResponse> updateUserInfo(UserUpdateInfoRequest user);
}
