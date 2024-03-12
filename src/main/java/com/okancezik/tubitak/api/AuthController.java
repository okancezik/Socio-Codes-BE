package com.okancezik.tubitak.api;


import com.okancezik.tubitak.business.abstracts.AuthenticationService;
import com.okancezik.tubitak.business.dtos.requests.AuthenticationRequest;
import com.okancezik.tubitak.business.dtos.requests.RegisterRequest;
import com.okancezik.tubitak.business.dtos.responses.AuthenticationResponse;
import com.okancezik.tubitak.core.results.DataResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authorization")
public class AuthController {

    private final AuthenticationService authenticationService;

    @Operation(
            description = "User register endpoint",
            summary = "User register",
            responses = {
                    @ApiResponse(
                            description = "success",
                            responseCode = "200"
                    )
            }
    )
    @PostMapping("/register")
    public DataResult<AuthenticationResponse> register(
        @RequestBody RegisterRequest request
    ){
        return authenticationService.register(request);
    }

    @Operation(
            description = "User login endpoint",
            summary = "User login",
            responses = {
                    @ApiResponse(
                            description = "success",
                            responseCode = "200"
                    )
            }
    )
    @PostMapping("/authenticate")
    public DataResult<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request,
            HttpServletResponse response
    ){
        return authenticationService.authenticate(request,response);
    }
}
