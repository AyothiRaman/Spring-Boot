package com.course.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.course.Entity.StudentEntity;
import com.course.Service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	
	@GetMapping("/student")
	public String getData(Model model){
		model.addAttribute("StudentList", studentservice.getAllData());
		 return "studentdetail";
	}

	@GetMapping("/add new student")
	public String addNewEmployee(Model model){
		StudentEntity student = new StudentEntity();
		model.addAttribute("student", student);
		return "studentmodel";
		
	}
	
	@PostMapping("/SaveStudent")
	public String giveData(StudentEntity entity) {
		studentservice.saveData(entity);
		return "redirect:/student";
		
	}
	
	
	@GetMapping("/updatedata/{id}")
	public String updateStudent(@PathVariable ("id") long id,Model model) {
		Optional<StudentEntity> stu = studentservice.findData(id);
		model.addAttribute("student", stu);
	    return "updatestudent";
	}


	
	  @GetMapping("/deletedata/{id}") 
	  public String deleteById(@PathVariable("id") long id,Model model) {
		  Optional<StudentEntity> stu = studentservice.findData(id); 
		  model.addAttribute("student", stu);
	  studentservice.deleteData(id);
	  
	  return"redirect:/student"; 
	  }
	 
	  @GetMapping("/wel")
		public String set() {
			return "welcome";
		}
		
	 

}
