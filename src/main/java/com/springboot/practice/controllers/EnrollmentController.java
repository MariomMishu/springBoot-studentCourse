package com.springboot.practice.controllers;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.practice.dto.BatchDto;
import com.springboot.practice.dto.EnrollmentDto;
import com.springboot.practice.dto.StudentDto;
import com.springboot.practice.entities.Batch;
import com.springboot.practice.entities.Course;
import com.springboot.practice.entities.Enrollment;
import com.springboot.practice.entities.Student;
import com.springboot.practice.request_models.BatchRm;
import com.springboot.practice.request_models.EnrollmentRm;
import com.springboot.practice.request_models.StudentRm;
import com.springboot.practice.ripository.CourseRepository;
import com.springboot.practice.ripository.EnrollmentRepository;
import com.springboot.practice.service.BatchService;
import com.springboot.practice.service.CourseService;
import com.springboot.practice.service.DepartmentService;
import com.springboot.practice.service.EnrollmentService;
import com.springboot.practice.service.SessionTrimesterService;
import com.springboot.practice.service.StudentService;

@Controller
public class EnrollmentController {
	
	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private DepartmentService deptService;
	
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private SessionTrimesterService sessionTrimesterService;
	
	@Autowired
	private EnrollmentService enrollmentService;
	
	@Autowired
	private EnrollmentRepository enrollRepo;
	@GetMapping("/enrollment")
    public String manageBatch (Model model) {
     //   model.addAttribute("title", "Manage Enrollment");
    	model.addAttribute("enrollment", new EnrollmentRm());
		model.addAttribute("trimestersList",sessionTrimesterService.getAll());
		model.addAttribute("departments",deptService.getAll());
		//model.addAttribute("student_list", studentService.getAll());
		model.addAttribute("course_list", courseService.getAll());
        return "/enrollment/manage-enrollment";
    }
	
	  @GetMapping(value = "/enrollment/getStudentList/{departmentId}", consumes = "application/json", produces = "application/json") 
	  public @ResponseBody List<StudentRm> getAllStudents(@PathVariable("departmentId") Long departmentId) {
		  List<Student> student_list = studentService.getAllStudents(departmentId);
	  System.out.println(student_list);
	  
	  return this.getStudentDtoRmList(student_list); 
	  }
	  private List<StudentRm> getStudentDtoRmList(List<Student> student_list) {
	        List<StudentRm> rmList = new ArrayList<>();
	        for (Student student : student_list) {
	        	StudentRm studentRm = new StudentRm();
	        	StudentDto studentDto = new StudentDto();
	            BeanUtils.copyProperties(student, studentDto);
	            studentRm.setId(studentDto.getId());
	            studentRm.setName(studentDto.getName());
	            rmList.add(studentRm);
	        }
	        return rmList;
	    }
	  @GetMapping(value = "/enrollment/ajaxGetAll", consumes = "application/json", produces = "application/json")
	    public @ResponseBody List<EnrollmentRm> ajaxGetAll() {
	        List<Enrollment> enrollList = enrollmentService.getAll();
	        return this.getDtoRmList(enrollList);
	    }
	   private List<EnrollmentRm> getDtoRmList(List<Enrollment> enrollList) {
	        List<EnrollmentRm> rmList = new ArrayList<>();
	        for (Enrollment enroll : enrollList) {
	        	EnrollmentRm enrollRm = new EnrollmentRm();
	        	EnrollmentDto enrollDto = new EnrollmentDto();
	            BeanUtils.copyProperties(enroll, enrollDto);
	            enrollRm.setId(enrollDto.getId());
	            enrollRm.setDepartmentId(enrollDto.getDepartment().getId());
	            enrollRm.setDepartmentName(enrollDto.getDepartment().getName());
	            enrollRm.setStudentId(enrollDto.getStudent().getId());
	            enrollRm.setStudentName(enrollDto.getStudent().getName());
	            enrollRm.setTrimesterId(enrollDto.getSessionTrimester().getId());
	            enrollRm.setTrimesterName(enrollDto.getSessionTrimester().getName());
	            rmList.add(enrollRm);
	        }
	        return rmList;
	    }
	 
	@GetMapping("/enrollment/add")
	public String add_GET(Model model) {
		model.addAttribute("enrollment", new EnrollmentRm());
		model.addAttribute("trimestersList",sessionTrimesterService.getAll());
		model.addAttribute("student_list", studentService.getAll());
		model.addAttribute("course_list", courseService.getAll());
		return "enrollment/add";
	}
	 
	@PostMapping("/enrollment/add")
	public String add(Model model, @ModelAttribute("enrollmentRm") EnrollmentRm enrollmentRm) {
		
		 	Optional<Enrollment> enrollOptional = enrollRepo.findById(enrollmentRm.getId());
		 	Enrollment enroll;
		 	EnrollmentDto enrollDto = new EnrollmentDto();
			AtomicReference<List<Course>> courseReference = new AtomicReference();
			System.out.println(enrollOptional.isEmpty());
			
			if (enrollOptional.isEmpty()) {
				enroll = new Enrollment();
	            courseReference.set(new ArrayList<>()); 
	        } else {
	        	enroll = enrollOptional.get();
	        	System.out.println(enrollOptional.get());
	        	courseReference.set(new ArrayList<>(enroll.getCourses())); 
	        	
	        }
	      
			enrollmentRm.getCourseIds().forEach(aLong -> {
	        	Course course = courseRepository.getOne(aLong);
	        	courseReference.get().add(course);
	        	System.out.println(courseReference.get());
	        });
			
	        var studentId = studentService.getById(enrollmentRm.getStudentId());
	        var trimesterId = sessionTrimesterService.getById(enrollmentRm.getTrimesterId());
	        
	        enrollDto.setStudent(studentId);
	        enrollDto.setSessionTrimester(trimesterId);
	        BeanUtils.copyProperties(enrollDto, enroll);	        
	        enroll.setCourses(courseReference.get());
	        enroll.setIsDelete(true);
	        enrollmentService.save(enroll);
		model.addAttribute("message", "New Enrollment Added Successfully");
		return "redirect:/enrollment/show-all";
	}
	
	@GetMapping("/enrollment/show-all")
	public String show_all(Model model) {
		model.addAttribute("enrollment_list", enrollmentService.getAll());
		model.addAttribute("message", "Showing All Enrollment");
		return "enrollment/show-all";
	}
	 @PostMapping(value = "/enrollment/ajaxAdd", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody EnrollmentRm ajaxAdd(@RequestBody EnrollmentRm enrollmentRm) {
		  LocalDateTime entry_date = LocalDateTime.now();
		 	Optional<Enrollment> enrollOptional = enrollRepo.findById(enrollmentRm.getId());
		 	Enrollment enroll;
		 	AtomicReference<List<Course>> courseReference = new AtomicReference();
			
			if (enrollOptional.isEmpty()) {
				enroll = new Enrollment();
	            courseReference.set(new ArrayList<>()); 
	        } else {
	        	enroll = enrollOptional.get();
	        	System.out.println(enrollOptional.get());
	        	courseReference.set(new ArrayList<>(enroll.getCourses())); 
	        	
	        }
	      
			enrollmentRm.getCourseIds().forEach(aLong -> {
	        	Course course = courseRepository.getOne(aLong);
	        	courseReference.get().add(course);
	        //	System.out.println(courseReference.get());
	        });
		  var trimesterId = batchService.getByTrimesterId(enrollmentRm.getTrimesterId());
		  var deptId = deptService.getById(enrollmentRm.getDepartmentId());
		  var studentId = studentService.getById(enrollmentRm.getStudentId());
		  EnrollmentDto enrollDto = new EnrollmentDto();
		  Enrollment enrollEntity = new Enrollment();
		   enrollDto.setDepartment(deptId);
		   enrollDto.setSessionTrimester(trimesterId);
		   enrollDto.setStudent(studentId);
		  BeanUtils.copyProperties(enrollDto, enrollEntity);
			enrollEntity.setCourses(courseReference.get());
			enrollEntity.setEntryDate(entry_date);
			enrollEntity.setIsDelete(true);
			enrollmentService.save(enrollEntity);
			enrollEntity = enrollmentService.getById(enrollEntity.getId());
	        BeanUtils.copyProperties(enrollEntity, enrollDto);
	        enrollmentRm.setId(enrollDto.getId());
	        enrollmentRm.setDepartmentId(enrollDto.getDepartment().getId());
	        enrollmentRm.setDepartmentName(enrollDto.getDepartment().getName());
	        enrollmentRm.setStudentId(enrollDto.getStudent().getId());
	        enrollmentRm.setStudentName(enrollDto.getStudent().getName());
	        enrollmentRm.setTrimesterId(enrollDto.getSessionTrimester().getId());
	        enrollmentRm.setTrimesterName(enrollDto.getSessionTrimester().getName());
	        return enrollmentRm;
	    }
	
	
}