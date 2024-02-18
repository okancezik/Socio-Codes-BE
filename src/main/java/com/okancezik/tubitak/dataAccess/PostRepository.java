package com.okancezik.tubitak.dataAccess;

import com.okancezik.tubitak.entity.concretes.Post;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllPostByUserId(PageRequest pageRequest, int userId);
    List<Post> findAllPostByBranchId(PageRequest pageRequest, int branchId);
}
