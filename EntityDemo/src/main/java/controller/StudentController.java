package controller;

import modelEntity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<StudentEntity> getData(){
        return studentService.getAllData();
    }

    @PostMapping
    public StudentEntity postData(@RequestBody StudentEntity entity){
        return studentService.saveData(entity);
    }

    @PutMapping()
    public ResponseEntity<StudentEntity> updateData(@PathVariable String first_name, @RequestBody StudentEntity enti){
        return studentService.updateStudent(first_name,enti);
    }

}
