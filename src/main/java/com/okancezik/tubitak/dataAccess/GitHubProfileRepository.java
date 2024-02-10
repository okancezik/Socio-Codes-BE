package com.okancezik.tubitak.dataAccess;

import com.okancezik.tubitak.entity.concretes.GitHubProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GitHubProfileRepository extends JpaRepository<GitHubProfile, Integer> {
}
