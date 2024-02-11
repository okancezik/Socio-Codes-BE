package com.okancezik.tubitak.business.abstracts;

import com.okancezik.tubitak.business.dtos.requests.UserRegisterRequest;

public interface UserService {
    void save(UserRegisterRequest user);
}
