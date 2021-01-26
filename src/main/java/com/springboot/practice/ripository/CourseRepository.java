package com.springboot.practice.ripository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.practice.entities.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	boolean existsByName(String name);
	List<Course> findAllByIsDeleteTrue();
	List<Course> findAllByDepartmentId(Long departmentId);
	Course findByDepartmentId(Long departmentId);
}
