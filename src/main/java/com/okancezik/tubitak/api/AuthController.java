package com.okancezik.tubitak.api;


import com.okancezik.tubitak.business.abstracts.AuthenticationService;
import com.okancezik.tubitak.business.dtos.requests.AuthenticationRequest;
import com.okancezik.tubitak.business.dtos.requests.RegisterRequest;
import com.okancezik.tubitak.business.dtos.responses.AuthenticationResponse;
import com.okancezik.tubitak.core.results.DataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public DataResult<AuthenticationResponse> register(
        @RequestBody RegisterRequest request
    ){
        return authenticationService.register(request);
    }

    @PostMapping("/authenticate")
    public DataResult<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return authenticationService.authenticate(request);
    }
}
