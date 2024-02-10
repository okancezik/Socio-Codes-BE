package com.okancezik.tubitak.dataAccess;

import com.okancezik.tubitak.entity.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
