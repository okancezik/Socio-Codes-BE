package com.okancezik.tubitak.business.conretes;

import com.okancezik.tubitak.business.abstracts.AuthenticationService;
import com.okancezik.tubitak.business.dtos.requests.AuthenticationRequest;
import com.okancezik.tubitak.business.dtos.requests.RegisterRequest;
import com.okancezik.tubitak.business.dtos.responses.AuthenticationResponse;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.core.results.SuccessDataResult;
import com.okancezik.tubitak.core.utils.mappers.ModelMapperService;
import com.okancezik.tubitak.dataAccess.UserRepository;
import com.okancezik.tubitak.entity.concretes.User;
import com.okancezik.tubitak.entity.enums.Role;
import com.okancezik.tubitak.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthenticationService {

    private final UserRepository repository;
    private final ModelMapperService mapperService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public DataResult<AuthenticationResponse> register(RegisterRequest request) {
       User user = mapperService.forRequest().map(request, User.class);
       user.setPassword(passwordEncoder.encode(request.getPassword()));
       user.setRole(Role.USER);
       repository.save(user);
       String jwt = jwtService.generateToken(user);
       var data =  AuthenticationResponse
               .builder()
               .token(jwt)
               .build();
       return new SuccessDataResult<>(data,"user registered successfully");
    }

    @Override
    public DataResult<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        String jwt = jwtService.generateToken(user);
        var data =  AuthenticationResponse
                .builder()
                .token(jwt)
                .build();
        return new SuccessDataResult<>(data,"login success");
    }
}
