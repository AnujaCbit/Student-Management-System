package lk.mmp.api.services;

import lk.mmp.api.component.StudentReqRes;
import lk.mmp.core.dao.StudentDAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    StudentDAO createAndUpdateStudent(StudentDAO studentDAO);

    StudentDAO getExistingStudent(StudentDAO studentDAO);

    List<StudentDAO> getAllStudents();

    StudentReqRes getStudentCources(long id);

}
