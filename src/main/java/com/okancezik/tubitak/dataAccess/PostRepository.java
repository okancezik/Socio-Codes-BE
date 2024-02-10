package com.okancezik.tubitak.dataAccess;

import com.okancezik.tubitak.entity.concretes.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
