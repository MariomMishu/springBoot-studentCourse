package com.springboot.practice.ripository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.practice.entities.Instructor;
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
