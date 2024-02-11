package com.okancezik.tubitak.business.abstracts;

import com.okancezik.tubitak.business.dtos.requests.UserRegisterRequest;
import com.okancezik.tubitak.core.results.Result;

public interface UserService {
    Result save(UserRegisterRequest user);
}
