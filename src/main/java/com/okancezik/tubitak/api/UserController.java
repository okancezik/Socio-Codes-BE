package com.okancezik.tubitak.api;

import com.okancezik.tubitak.business.abstracts.UserService;
import com.okancezik.tubitak.business.dtos.requests.UserRegisterRequest;
import com.okancezik.tubitak.business.dtos.responses.UserScoreModelResponse;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.core.results.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public Result save(@RequestBody UserRegisterRequest user) {
        return service.save(user);
    }

    @GetMapping("/score")
    public DataResult<List<UserScoreModelResponse>> getUserScoreList(@RequestParam(required = false) Integer branchId) {
        return service.getUserScoreList();
    }
}