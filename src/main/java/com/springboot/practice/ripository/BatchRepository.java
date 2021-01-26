package com.springboot.practice.ripository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.practice.entities.Batch;
public interface BatchRepository extends JpaRepository<Batch, Long> {
	boolean existsByName(String name);
	List<Batch> findAllByIsDeleteTrue();
}
