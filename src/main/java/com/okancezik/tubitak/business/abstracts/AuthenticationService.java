package com.okancezik.tubitak.business.abstracts;

import com.okancezik.tubitak.business.dtos.requests.AuthenticationRequest;
import com.okancezik.tubitak.business.dtos.requests.RegisterRequest;
import com.okancezik.tubitak.business.dtos.responses.AuthenticationResponse;
import com.okancezik.tubitak.core.results.DataResult;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthenticationService {
    DataResult<AuthenticationResponse> register(RegisterRequest request);
    DataResult<AuthenticationResponse> authenticate(AuthenticationRequest request, HttpServletResponse response);
}
