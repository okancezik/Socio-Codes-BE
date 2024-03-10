package com.okancezik.tubitak.business.abstracts;

import com.okancezik.tubitak.business.dtos.requests.UserUpdateInfoRequest;
import com.okancezik.tubitak.business.dtos.responses.UserDetailResponse;
import com.okancezik.tubitak.business.dtos.responses.UserScoreModelResponse;
import com.okancezik.tubitak.core.results.DataResult;


import java.util.List;

public interface UserService {

    DataResult<List<UserScoreModelResponse>> getUserScoreList();

    DataResult<UserDetailResponse> getUserDetailById(int id);

    DataResult<UserDetailResponse> updateUserInfo(UserUpdateInfoRequest user);
}
