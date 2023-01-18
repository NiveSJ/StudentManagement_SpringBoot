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
   @JoinColumn(name= "department_id")
   private Department department;
  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(courseName, course.courseName) && Objects.equals(semester, course.semester) && Objects.equals(department, course.department) && Objects.equals(student, course.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, semester, department, student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", semester='" + semester + '\'' +
                ", department=" + department +
                ", student=" + student +
                '}';
    }
}