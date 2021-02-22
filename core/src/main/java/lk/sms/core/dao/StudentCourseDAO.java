package lk.sms.core.dao;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class StudentCourseDAO {

    private StudentDAO student;
    private CourseDAO course;
    private boolean isLearning;

}
