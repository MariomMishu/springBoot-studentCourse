package com.springboot.practice.ripository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.practice.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, String>{ 
	Role findByAuthority(String authority);
	boolean existsByAuthority(String authority);
}
