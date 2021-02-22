package lk.mmp.core.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "course")

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private long duration;
    private boolean isDeleted;

    @OneToMany(mappedBy = "course", orphanRemoval = true,
                fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<StudentCourse> studentCourses;

}
