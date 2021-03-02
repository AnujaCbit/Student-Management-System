package lk.rumex.sms.api.controller;

import lk.rumex.sms.api.services.StudentService;
import lk.rumex.sms.api.component.StudentReqRes;
import lk.rumex.sms.core.dao.StudentDAO;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(path = "")
    public ResponseEntity create(@RequestBody @Valid StudentReqRes student) {

        StudentDAO studentDAO = modelMapper.map(student, StudentDAO.class);
        log.info("Object Converted to dao : " + studentDAO.toString());
        studentService.createAndUpdateStudent(studentDAO);
        log.info("End of the method");
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(path = "")
    public ResponseEntity update(@RequestBody @Valid StudentReqRes student) {

        StudentDAO studentDAO = modelMapper.map(student, StudentDAO.class);
        log.info("Object Converted to dao : " + studentDAO.toString());
        StudentDAO existingStudent = studentService.getExistingStudent(studentDAO);

        if (existingStudent == null) {
            log.warn("No existing student for update process");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        existingStudent.setName(student.getName());
        existingStudent.setBirthDay(student.getBirthDay());

        studentService.createAndUpdateStudent(existingStudent);
        log.info("End of the method");
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity getAll() {
        log.info("Find all triggered");
        List<StudentDAO> allStudents = studentService.getAllStudents();
        List<StudentReqRes> collect = allStudents.stream().
                map(studentDAO -> modelMapper.map(studentDAO, StudentReqRes.class)).
                collect(Collectors.toList());
        log.info("Array Converted to ReqRes : ");

        return new ResponseEntity(allStudents, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getStudentById(@PathVariable("id") Long id) {
        StudentReqRes student = studentService.getStudentCources(id);
        if (student == null) {
            log.warn("No Student Exists");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(student, HttpStatus.OK);
    }


}
