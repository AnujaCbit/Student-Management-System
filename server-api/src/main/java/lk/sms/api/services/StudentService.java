package lk.sms.api.services;

import lk.sms.api.component.StudentReqRes;
import lk.sms.core.dao.StudentDAO;

import java.util.List;

public interface StudentService {

    StudentDAO createAndUpdateStudent(StudentDAO studentDAO);

    StudentDAO getExistingStudent(StudentDAO studentDAO);

    List<StudentDAO> getAllStudents();

    StudentReqRes getStudentCources(long id);

}
