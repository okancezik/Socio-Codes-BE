package com.okancezik.tubitak.api;

import com.okancezik.tubitak.business.abstracts.UserService;
import com.okancezik.tubitak.business.dtos.requests.UserUpdateInfoRequest;
import com.okancezik.tubitak.business.dtos.responses.UserDetailResponse;
import com.okancezik.tubitak.business.dtos.responses.UserScoreModelResponse;
import com.okancezik.tubitak.core.results.DataResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(
            description = "Users score list endpoint",
            summary = "Users score list",
            responses = {
                    @ApiResponse(
                            description = "Listed",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @GetMapping("/score")
    public DataResult<List<UserScoreModelResponse>> getUserScoreList(@RequestParam(required = false) Integer branchId) {
        return service.getUserScoreList();
    }

    @Operation(
            description = "User detail list endpoint",
            summary = "User detail list",
            responses = {
                    @ApiResponse(
                            description = "Listed",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @GetMapping("{id}")
    public DataResult<UserDetailResponse> getUserDetailById(@PathVariable int id) {
        return service.getUserDetailById(id);
    }

    @Operation(
            description = "User info update endpoint",
            summary = "User info update",
            responses = {
                    @ApiResponse(
                            description = "Listed",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @PostMapping("/update-user")
    public DataResult<UserDetailResponse> updateUser(@RequestBody UserUpdateInfoRequest user) {
        return service.updateUserInfo(user);
    }
}