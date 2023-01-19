package se.lexicon.studentmanagement_springboot.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(nullable = false,unique = true)
    private String courseName;
    @Column(nullable = false)
    private int semester;
   @ManyToOne
   @JoinColumn(name= "department_id")
   private Department department;
  @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,
          CascadeType.PERSIST,CascadeType.REFRESH})
  @JoinColumn(name = "student_id")
  private List<Student> studentList= new ArrayList<>();

    public Course(String courseName, int semester) {

        this.courseName = courseName;
        this.semester = semester;

    }

    public Course() {

    }

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

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }


    public void addStudent(Student student) {
        studentList.add(student);
        student.getCourseList().add(this);
    }
    public void removeStudent(Student student) {
        student.getCourseList().remove(this);
        studentList.remove(student);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(courseName, course.courseName) && Objects.equals(semester, course.semester) && Objects.equals(department, course.department) && Objects.equals(studentList, course.studentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, semester, department, studentList);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", semester='" + semester + '\'' +
                ", department=" + department +
                ", studentList=" + studentList +
                '}';
    }
}