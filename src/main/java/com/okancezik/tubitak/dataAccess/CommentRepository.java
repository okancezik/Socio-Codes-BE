package com.okancezik.tubitak.dataAccess;

import com.okancezik.tubitak.entity.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    Optional<List<Comment>> findByPost_Id(int postId);
}
