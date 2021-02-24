package lk.rumex.sms.api.services;

import lk.rumex.sms.api.component.StudentReqRes;
import lk.rumex.sms.core.dao.StudentDAO;

import java.util.List;

public interface StudentService {

    StudentDAO createAndUpdateStudent(StudentDAO studentDAO);

    StudentDAO getExistingStudent(StudentDAO studentDAO);

    List<StudentDAO> getAllStudents();

    StudentReqRes getStudentCources(long id);

}
