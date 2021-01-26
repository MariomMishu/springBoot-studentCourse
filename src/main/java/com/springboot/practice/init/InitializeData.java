package com.springboot.practice.init;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;

import com.springboot.practice.entities.Department;
import com.springboot.practice.entities.Trimester;
import com.springboot.practice.ripository.DepartmentRepository;
import com.springboot.practice.ripository.TrimesterRepository;

public class InitializeData implements CommandLineRunner{
	
	private final DepartmentRepository deptRepository;
	private final TrimesterRepository trimesterRepository;
	
	public InitializeData(DepartmentRepository deptRepository,TrimesterRepository trimesterRepository) {
		this.deptRepository = deptRepository;
		this.trimesterRepository = trimesterRepository;

	}
	
	@Override
	public void run(String... args) throws Exception {
		Stream.of(
				new String[]{"Spring", "1"},
				new String[]{"Summer", "2"},
				new String[]{"Fall", "3"})
		.filter(s-> !trimesterRepository.existsByName(s[0]))
		.map(arr->{
			Trimester trimester = new Trimester();
			trimester.setName(arr[0]);
			trimester.setCode(arr[1]);
			return trimesterRepository.save(trimester);
		}).forEach(trimester->System.out.println(trimester.toString()));
		
	Stream.of("CSE", "EEE", "BBA")
        .filter(name -> !deptRepository.existsByName(name))
        .map(s -> {
            Department designation = new Department();
            designation.setName(s);
            deptRepository.save(designation);
            return designation;
        }).forEach(designation->{
			System.out.println(designation.getId());
		});

		System.out.println("Spring Boot Initializer");
	}
	
	
}
