package lk.rumex.sms.core.domain;

import lk.rumex.sms.core.common.StudentCourseID;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "student_course")
@IdClass(StudentCourseID.class)

public class StudentCourse {

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    private boolean isLearning;

}
