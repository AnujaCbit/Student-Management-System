package lk.rumex.sms.api.component;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Data
public class StudentReqRes {

    @NotNull(message = "Name can't be empty")
    private String name;

    @NotNull(message = "bod can't be empty")
    private LocalDateTime birthDay;

    private List<CourseReqRes> courseReqResList;

}
