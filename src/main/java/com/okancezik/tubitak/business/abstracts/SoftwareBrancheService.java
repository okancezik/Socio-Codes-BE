package com.okancezik.tubitak.business.abstracts;

import com.okancezik.tubitak.business.dtos.responses.SoftwareBranchListModelResponse;
import com.okancezik.tubitak.core.results.DataResult;

import java.util.List;

public interface SoftwareBrancheService {
    DataResult<List<SoftwareBranchListModelResponse>> getDropdownList();
}
