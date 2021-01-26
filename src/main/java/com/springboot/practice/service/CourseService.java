package com.springboot.practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.springboot.practice.dto.CourseDto;
import com.springboot.practice.entities.Course;
import com.springboot.practice.entities.Student;
import com.springboot.practice.ripository.CourseRepository;

@Service
public class CourseService {
	private final CourseRepository courseRepo;

	    public CourseService(CourseRepository courseRepo) {
	        this.courseRepo = courseRepo;
	    }

	    public List<Course> getAll(){
	        return courseRepo.findAll();
	    }

	    public List<CourseDto> getAllDto(){
	        List<CourseDto> courseDtos = new ArrayList<>();
	        courseRepo.findAll().stream().forEach(course -> {
	        	CourseDto courseDto = new CourseDto();
	            BeanUtils.copyProperties(course, courseDto);
	            courseDtos.add(courseDto);
	        });
	        return courseDtos;
	    }

	    public void save(Course course){
	    	courseRepo.save(course);
	    }

	/*
	 * public Course getById(long courseId) { return courseRepo.getOne(courseId); }
	 */
	    public List<Course> getAllCourses(long departmentId) { 
			 List<Course> course_list = courseRepo.findAllByDepartmentId(departmentId); 
			// System.out.println(student_list);
			 return course_list;
			 } 
	    public Course getById(long Id) {
	        Optional<Course> optionalCourse = courseRepo.findById(Id);
	        if (optionalCourse.isEmpty()) {
	            throw new RuntimeException("Student Not Find By this Id");
	        } else {
	            return optionalCourse.get();
	        }
	    }
}
