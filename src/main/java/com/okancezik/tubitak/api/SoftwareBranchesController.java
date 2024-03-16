package com.okancezik.tubitak.api;

import com.okancezik.tubitak.business.abstracts.SoftwareBrancheService;
import com.okancezik.tubitak.business.dtos.responses.SoftwareBranchListModelResponse;
import com.okancezik.tubitak.core.results.DataResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/software-branch")
@RequiredArgsConstructor
@Tag(name = "Software Branches")
public class SoftwareBranchesController {

    private final SoftwareBrancheService service;

    @Operation(
            description = "Branches dropdown list endpoint",
            summary = "Branches dropdown list",
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
    @GetMapping
    public DataResult<List<SoftwareBranchListModelResponse>> dropdownList(){
        return service.getDropdownList();
    }
}
