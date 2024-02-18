package com.okancezik.tubitak.business.abstracts;

import com.okancezik.tubitak.business.dtos.requests.UserRegisterRequest;
import com.okancezik.tubitak.business.dtos.responses.UserScoreModelResponse;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.core.results.Result;

import java.util.List;

public interface UserService {
    Result save(UserRegisterRequest user);

    DataResult<List<UserScoreModelResponse>> getUserScoreList();
}
