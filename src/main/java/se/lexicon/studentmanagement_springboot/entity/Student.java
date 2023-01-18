package se.lexicon.studentmanagement_springboot.entity;


import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
@Entity
public class Student {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy="org.hibernate.id.UUIDGenerator")

    private String id;

    @Column(nullable = false,length = 100)
    private String firstName;
    @Column(nullable = false,length = 100)
    private String lastName;
    @Column(nullable = false,length = 120,unique = true)
    private String email;
    @Column(nullable = false)
    private LocalDate birthDate;
    private LocalDateTime registrationDate;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id") // Like reference name
    private Department department; // Foreign key

    @OneToMany(mappedBy = "students")
    @JoinColumn(name = "course_id") // Like reference name
    private List<Course> courseList;  // Foreign key

    public Student() {
        this.registrationDate = LocalDateTime.now();
    }


}