package service;

import modelEntity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.ResourceAccessException;
import repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;



    public List<StudentEntity> getAllData() {
        return (List<StudentEntity>) studentRepository.findAll();

    }

    public StudentEntity saveData(@RequestBody StudentEntity entity) {
        return studentRepository.save(entity);
    }

    public ResponseEntity<StudentEntity> updateStudent(@PathVariable String first_name, @RequestBody StudentEntity studentDetails) {
        StudentEntity student = studentRepository.findById(first_name)
                .orElseThrow(() -> new ResourceAccessException("Employee not exist with id: " + first_name));

        student.setFirst_name(studentDetails.getFirst_name());
        student.setLast_name(studentDetails.getLast_name());
        student.setLocation(studentDetails.getLocation());
        final StudentEntity updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }
}
