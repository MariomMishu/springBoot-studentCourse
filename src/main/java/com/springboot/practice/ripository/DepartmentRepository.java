package com.springboot.practice.ripository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.practice.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	boolean existsByName(String name);
	Department findByName(String name);
	//List<Department> findAllByIsDeleteTrue();
	
}
