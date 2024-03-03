package com.okancezik.tubitak.dataAccess;

import com.okancezik.tubitak.entity.concretes.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like,Integer> {

    Optional<Like> findByPost_IdAndUser_Id(int postId, int studentId);

}
