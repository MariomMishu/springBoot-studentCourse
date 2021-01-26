package com.springboot.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.springboot.practice.entities.Department;
import com.springboot.practice.ripository.DepartmentRepository;
@Service
public class DepartmentService {
	private final DepartmentRepository deptRepo;

    public DepartmentService(DepartmentRepository deptRepo) {
        this.deptRepo = deptRepo;
    }
    public boolean add(Department depEntity) {
    	
		if(!exists(depEntity.getName())) {
			
			deptRepo.save(depEntity);
			return true;
		}else {
			return false;
		}
	}
	
	
	private boolean exists(String name) {
		if(getDepartmentByName(name)!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	public Department getDepartmentByName(String name) {
		 return deptRepo.findByName(name); 
	}
	
    public void edit(Department dept) {
    	deptRepo.save(dept);
    }
    public List<Department> getAll() {
		return (List<Department>) deptRepo.findAll();
	}
    public Department getById(long Id) {
        Optional<Department> optionalDept = deptRepo.findById(Id);
        if (optionalDept.isEmpty()) {
            throw new RuntimeException("Student Not Find By this Id");
        } else {
            return optionalDept.get();
        }
    }
}
