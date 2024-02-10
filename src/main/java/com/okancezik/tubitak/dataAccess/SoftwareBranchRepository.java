package com.okancezik.tubitak.dataAccess;

import com.okancezik.tubitak.entity.concretes.SoftwareBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareBranchRepository extends JpaRepository<SoftwareBranch, Integer> {
}
