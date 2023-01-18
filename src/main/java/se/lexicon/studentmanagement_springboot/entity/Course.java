package se.lexicon.studentmanagement_springboot.entity;

import org.hibernate.annotations.GenericGenerator;
import se.lexicon.studentmanagement_springboot.entity.Department;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(nullable = false)
    private String courseName;
    @Column(nullable = false)
    private String semester;
   @ManyToOne
   private Department department;
  @OneToMany
  private List<Student> students;
}