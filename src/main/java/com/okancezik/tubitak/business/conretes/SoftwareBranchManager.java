package com.okancezik.tubitak.business.conretes;

import com.okancezik.tubitak.business.abstracts.SoftwareBrancheService;
import com.okancezik.tubitak.business.dtos.responses.SoftwareBranchListModelResponse;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.core.results.SuccessDataResult;
import com.okancezik.tubitak.core.utils.mappers.ModelMapperService;
import com.okancezik.tubitak.dataAccess.SoftwareBranchRepository;
import com.okancezik.tubitak.entity.concretes.SoftwareBranch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SoftwareBranchManager implements SoftwareBrancheService {

    private final SoftwareBranchRepository repository;
    private final ModelMapperService mapperService;

    @Override
    public DataResult<List<SoftwareBranchListModelResponse>> getDropdownList() {
        List<SoftwareBranch> data = repository.findAll();

        List<SoftwareBranchListModelResponse> branches =
                data.stream().map(
                        softwareBranch -> mapperService.forResponse()
                                .map(softwareBranch,SoftwareBranchListModelResponse.class))
                        .collect(Collectors.toList());

        return new SuccessDataResult<>(branches,"Listed software branches");
    }
}
