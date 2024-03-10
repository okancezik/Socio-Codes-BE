package com.okancezik.tubitak.dataAccess;

import com.okancezik.tubitak.entity.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
