package com.okancezik.tubitak.api;

import com.okancezik.tubitak.business.abstracts.SoftwareBrancheService;
import com.okancezik.tubitak.business.dtos.responses.SoftwareBranchListModelResponse;
import com.okancezik.tubitak.core.results.DataResult;
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
public class SoftwareBranchesController {

    private final SoftwareBrancheService service;

    @GetMapping
    public DataResult<List<SoftwareBranchListModelResponse>> dropdownList(){
        return service.getDropdownList();
    }
}
