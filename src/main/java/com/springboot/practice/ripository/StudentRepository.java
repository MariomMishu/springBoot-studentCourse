package com.springboot.practice.ripository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.practice.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	 List<Student> findAll();
	 List<Student> findAllByIsDeleteTrue();
	 List<Student> findAllByDepartmentId(Long departmentId);
}
