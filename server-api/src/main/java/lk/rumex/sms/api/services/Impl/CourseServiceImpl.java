package lk.rumex.sms.api.services.Impl;

import lk.rumex.sms.api.component.CourseReqRes;
import lk.rumex.sms.core.repository.CourseRepository;
import lk.rumex.sms.api.services.CourseService;
import lk.rumex.sms.core.dao.CourseDAO;
import lk.rumex.sms.core.domain.Course;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CourseDAO createAndUpdateCourse(CourseDAO courseDAO) {
        Course course = modelMapper.map(courseDAO, Course.class);
        Course save = courseRepository.save(course);
        log.info("Course saved");

        return modelMapper.map(save, CourseDAO.class);
    }

    @Override
    public CourseDAO getExistingStudent(CourseDAO courseDAO) {
        Optional<Course> course = courseRepository.findById(courseDAO.getId());
        return modelMapper.map(course.get(), CourseDAO.class);
    }

    @Override
    public List<CourseDAO> getAllCourses() {
        List<Course> all = courseRepository.findAll();

        log.info("Fetched all courses");
        return all.stream().
                map(course -> modelMapper.map(course, CourseDAO.class)).
                collect(Collectors.toList());
    }

    @Override
    public CourseDAO deleteCourse(long id) {
        Optional<Course> course = courseRepository.findById(id);
        course.get().setDeleted(true);

        Course deletedCourse = courseRepository.save(course.get());
        log.info("Course deleted");
        return modelMapper.map(deletedCourse, CourseDAO.class);
    }

    @Override
    public CourseReqRes getCourseStudents(long id) {
        Course one = courseRepository.getOne(id);
        return modelMapper.map(one, CourseReqRes.class);
    }

}
