package lk.sms.core.common;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
// not a b
@Data
public class StudentCourseID implements Serializable {

    private Long student;

    private Long course;

}
