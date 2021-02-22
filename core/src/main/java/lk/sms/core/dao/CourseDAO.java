package lk.sms.core.dao;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CourseDAO {

    private long id;
    private String name;
    private long duration;


}
