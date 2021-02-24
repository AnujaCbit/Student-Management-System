package lk.rumex.sms.api.component;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@Data
public class CourseReqRes {

//    @NotNull
    private long id;

    @NotNull
    private String name;

    @NotNull
    private long duration;

    private List<StudentReqRes> StudentList;

}
