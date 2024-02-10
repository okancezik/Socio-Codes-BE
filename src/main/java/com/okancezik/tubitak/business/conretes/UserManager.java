package com.okancezik.tubitak.business.conretes;

import com.okancezik.tubitak.business.abstracts.UserService;
import com.okancezik.tubitak.dataAccess.UserRepository;
import com.okancezik.tubitak.entity.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository repository;
    @Override
    public void save(User user) {
        repository.save(user);
    }
}
