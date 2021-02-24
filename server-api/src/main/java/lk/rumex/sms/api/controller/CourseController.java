package lk.rumex.sms.api.controller;

import lk.rumex.sms.api.component.CourseReqRes;
import lk.rumex.sms.api.services.CourseService;
import lk.rumex.sms.core.dao.CourseDAO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path ="api/v1/course", produces = { "application/json", "application/xml" })
@Slf4j
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(path = "")
    public ResponseEntity create(@RequestBody @Valid CourseReqRes course) {

        CourseDAO courseDAO = modelMapper.map(course, CourseDAO.class);
        courseService.createAndUpdateCourse(courseDAO);
        log.info("Course Created");

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(path = "")
    public ResponseEntity update(@RequestBody @Valid CourseReqRes course) {

        CourseDAO courseDAO = modelMapper.map(course, CourseDAO.class);
        CourseDAO existingCourse = courseService.getExistingStudent(courseDAO);

        if (existingCourse == null) {
            log.warn("Course doesn't exists");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        existingCourse.setName(course.getName());
        existingCourse.setDuration(course.getDuration());

        courseService.createAndUpdateCourse(existingCourse);
        log.info("Course Updated");

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getStudentById(@PathVariable("tv-show") Long id) {
        CourseReqRes courseReqRes = courseService.getCourseStudents(id);
        if (courseReqRes == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(courseReqRes, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteCourse(@PathVariable("tv-show") Long id) {
        CourseDAO courseDAO = courseService.deleteCourse(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "")
    public String testEndpoint() {
        return "<h1>Hellooooooooooo</h1>";
    }

}
