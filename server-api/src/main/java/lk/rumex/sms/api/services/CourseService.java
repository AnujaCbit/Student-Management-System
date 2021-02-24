package lk.rumex.sms.api.services;

import lk.rumex.sms.api.component.CourseReqRes;
import lk.rumex.sms.core.dao.CourseDAO;

import java.util.List;

public interface CourseService {

    CourseDAO createAndUpdateCourse(CourseDAO courseDAO);

    CourseDAO getExistingStudent(CourseDAO courseDAO);

    List<CourseDAO> getAllCourses();

    CourseDAO deleteCourse(long id);

    CourseReqRes getCourseStudents(long id);

}
