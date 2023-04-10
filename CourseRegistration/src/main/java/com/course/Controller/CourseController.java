package com.course.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.course.Entity.CourseEntity;
import com.course.Entity.StudentCourseEntity;
import com.course.Repository.CourseRepository;
import com.course.Service.CourseService;
import com.course.Service.StudentCourseService;



@Controller
public class CourseController {
	@Autowired
	private CourseService courseservice;
	
	@Autowired
	private StudentCourseService ser;
	

	// Methods for Select Course
	

	@GetMapping("/course")
	public String getBookedDetails(Model model) {
		 model.addAttribute("CourseList",courseservice.findCourse());
		return "CourseRegister";
		
	}

	
	@GetMapping("/selectcourse")
	public String addNewEmployee(Model model){
		CourseEntity course = new CourseEntity();
		model.addAttribute("course", course);
		return "courseselect";
	}
	
	@PostMapping("/savedata")
	public String selectCourse(CourseEntity entity){
		 courseservice.saveCourse(entity);
		 return "redirect:/course";
	}
	
	// Methods for booking Course
	

	
	@GetMapping("/bookdata")
	public String addNewCourse(Model model){
		StudentCourseEntity course = new StudentCourseEntity();
		model.addAttribute("bookcourse", course);
		return "coursebooked";
	}
		
	@PostMapping("/saveCourse")
	public String saveCourse(StudentCourseEntity ent){
	   ser.saveCourse(ent);
		 return "booked";
	}
	
	@GetMapping("/find")
	public String getData(Model model) {
		 model.addAttribute("BookedList",ser.getBookedDetails());
		return "bookinghistory";
		
	}
	


}
