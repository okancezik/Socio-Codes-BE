package com.okancezik.tubitak.business.abstracts;

import com.okancezik.tubitak.business.dtos.requests.AuthenticationRequest;
import com.okancezik.tubitak.business.dtos.requests.RegisterRequest;
import com.okancezik.tubitak.business.dtos.responses.AuthenticationResponse;
import com.okancezik.tubitak.core.results.DataResult;

public interface AuthenticationService {
    DataResult<AuthenticationResponse> register(RegisterRequest request);
    DataResult<AuthenticationResponse> authenticate(AuthenticationRequest request);
}
