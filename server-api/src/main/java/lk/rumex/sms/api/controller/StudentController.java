package lk.rumex.sms.api.controller;

import lk.rumex.sms.api.services.StudentService;
import lk.rumex.sms.api.component.StudentReqRes;
import lk.rumex.sms.core.dao.StudentDAO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(path = "")
    public ResponseEntity create(@RequestBody @Valid StudentReqRes student) {

        StudentDAO studentDAO = modelMapper.map(student, StudentDAO.class);
        studentService.createAndUpdateStudent(studentDAO);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(path = "")
    public ResponseEntity update(@RequestBody @Valid StudentReqRes student) {

        StudentDAO studentDAO = modelMapper.map(student, StudentDAO.class);
        StudentDAO existingStudent = studentService.getExistingStudent(studentDAO);

        if (existingStudent == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        existingStudent.setName(student.getName());
        existingStudent.setBirthDay(student.getBirthDay());

        studentService.createAndUpdateStudent(existingStudent);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity getAll() {
        List<StudentDAO> allStudents = studentService.getAllStudents();
        List<StudentReqRes> collect = allStudents.stream().
                map(studentDAO -> modelMapper.map(studentDAO, StudentReqRes.class)).
                collect(Collectors.toList());

        return new ResponseEntity(allStudents, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getStudentById(@PathVariable("tv-show") Long id) {
        StudentReqRes studentCources = studentService.getStudentCources(id);
        if (studentCources == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(studentCources, HttpStatus.OK);
    }


}
