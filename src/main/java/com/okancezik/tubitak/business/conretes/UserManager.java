package com.okancezik.tubitak.business.conretes;

import com.okancezik.tubitak.business.abstracts.UserService;
import com.okancezik.tubitak.business.dtos.requests.UserRegisterRequest;
import com.okancezik.tubitak.business.dtos.responses.UserScoreModelResponse;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.core.results.Result;
import com.okancezik.tubitak.core.results.SuccessDataResult;
import com.okancezik.tubitak.core.results.SuccessResult;
import com.okancezik.tubitak.core.utils.mappers.ModelMapperService;
import com.okancezik.tubitak.dataAccess.UserRepository;
import com.okancezik.tubitak.entity.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository repository;
    private final ModelMapperService mapper;

    @Override
    public Result save(UserRegisterRequest user) {
        User addUser= mapper.forRequest().map(user, User.class);
        repository.save(addUser);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<UserScoreModelResponse>> getUserScoreList() {
        List<User> users = repository.findAll(Sort.by(Sort.Direction.DESC,"point"));
        List<UserScoreModelResponse> userScoreModelResponses = users.stream()
                .map(user -> mapper.forResponse().map(user, UserScoreModelResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(userScoreModelResponses,"Listed user score list");
    }
}
