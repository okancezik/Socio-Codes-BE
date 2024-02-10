package com.okancezik.tubitak.dataAccess;

import com.okancezik.tubitak.entity.concretes.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
