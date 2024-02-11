package com.okancezik.tubitak.business.conretes;

import com.okancezik.tubitak.business.abstracts.UserService;
import com.okancezik.tubitak.business.dtos.requests.UserRegisterRequest;
import com.okancezik.tubitak.core.utils.mappers.ModelMapperService;
import com.okancezik.tubitak.dataAccess.UserRepository;
import com.okancezik.tubitak.entity.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository repository;
    private final ModelMapperService mapper;

    @Override
    public void save(UserRegisterRequest user) {
        User addUser= mapper.forRequest().map(user, User.class);
        repository.save(addUser);
    }
}
