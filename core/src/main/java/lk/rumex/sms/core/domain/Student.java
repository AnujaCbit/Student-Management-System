package lk.rumex.sms.core.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private LocalDateTime birthDay;

    @OneToMany(mappedBy = "student", orphanRemoval = true,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<StudentCourse> studentCourses;

}
