package lk.mmp.core.dao;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@Component
public class StudentDAO {

    private long id;
    private String name;
    private LocalDateTime birthDay;

}
