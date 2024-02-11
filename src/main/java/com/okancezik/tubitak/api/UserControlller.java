package com.okancezik.tubitak.api;

import com.okancezik.tubitak.business.abstracts.UserService;
import com.okancezik.tubitak.business.dtos.requests.UserRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserControlller {
    private final UserService service;

    @PostMapping
    public void save(@RequestBody UserRegisterRequest user){
        service.save(user);
    }
}
