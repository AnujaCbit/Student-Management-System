package lk.mmp.api.services;

import lk.mmp.api.component.CourseReqRes;
import lk.mmp.core.dao.CourseDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    CourseDAO createAndUpdateCourse(CourseDAO courseDAO);

    CourseDAO getExistingStudent(CourseDAO courseDAO);

    List<CourseDAO> getAllCourses();

    CourseDAO deleteCourse(long id);

    CourseReqRes getCourseStudents(long id);

}
