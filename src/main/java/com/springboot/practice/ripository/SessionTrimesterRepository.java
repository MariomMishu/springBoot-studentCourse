package com.springboot.practice.ripository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.practice.entities.SessionTrimester;
@Repository
public interface SessionTrimesterRepository extends JpaRepository<SessionTrimester, Long>{
	List<SessionTrimester> findAllByIsDeleteTrue();
}
