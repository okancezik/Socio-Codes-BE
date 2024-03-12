package com.okancezik.tubitak.api;

import com.okancezik.tubitak.business.abstracts.UserService;
import com.okancezik.tubitak.business.dtos.requests.UserUpdateInfoRequest;
import com.okancezik.tubitak.business.dtos.responses.UserDetailResponse;
import com.okancezik.tubitak.business.dtos.responses.UserScoreModelResponse;
import com.okancezik.tubitak.core.results.DataResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Tag(name = "User")
public class UserController {
    private final UserService service;

    @GetMapping("/score")
    public DataResult<List<UserScoreModelResponse>> getUserScoreList(@RequestParam(required = false) Integer branchId) {
        return service.getUserScoreList();
    }

    @GetMapping("{id}")
    public DataResult<UserDetailResponse> getUserDetailById(@PathVariable int id) {
        return service.getUserDetailById(id);
    }

    @PostMapping("/update-user")
    public DataResult<UserDetailResponse> updateUser(@RequestBody UserUpdateInfoRequest user) {
        return service.updateUserInfo(user);
    }
}