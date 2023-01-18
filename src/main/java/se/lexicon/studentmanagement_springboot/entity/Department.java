package se.lexicon.studentmanagement_springboot.entity;


import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.List;


@Entity
public class Department {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String department_id;
    @Column(nullable = false)
    private String Name;

    @OneToMany
    @JoinColumn(name= "course_id")
    private List<Course> courseList;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "department")  // Look at student class and refer the join column at
    // join colum of department filed
    private List<Student> students;




}