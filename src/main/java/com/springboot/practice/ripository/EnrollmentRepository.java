package com.springboot.practice.ripository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.practice.entities.Enrollment;
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{
	//boolean existsByName(String name);
	//Enrollment findByName(String name);
	List<Enrollment> findAllByIsDeleteTrue();
}
