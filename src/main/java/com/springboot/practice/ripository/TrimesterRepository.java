package com.springboot.practice.ripository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.practice.entities.Trimester;

@Repository
public interface TrimesterRepository extends JpaRepository<Trimester, Long>{
	boolean existsByName(String name);
}
