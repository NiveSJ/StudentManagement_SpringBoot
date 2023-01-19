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
    @ManyToOne
    @JoinColumn(name = "department_id") // Like reference name
    private Department department; // Foreign key

    @ManyToMany (mappedBy = "studentList")
    private List<Course> courseList;

    public Student() {
        this.registrationDate = LocalDateTime.now();
    }

    public Student(String firstName, String lastName, String email, LocalDate birthDate) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    // Add student and remove student

    // private List<Course> courseList;

    public void addCourse(Course course) {
        courseList.add(course);
        course.getStudentList().add(this);
    }
    public void removeCourse(Course course) {
        course.getStudentList().remove(this);
        courseList.remove(course);
    }










    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(email, student.email) && Objects.equals(birthDate, student.birthDate) && Objects.equals(registrationDate, student.registrationDate) && Objects.equals(department, student.department) && Objects.equals(courseList, student.courseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, birthDate, registrationDate, department, courseList);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", registrationDate=" + registrationDate +
                ", department=" + department +
                ", courseList=" + courseList +
                '}';
    }
}