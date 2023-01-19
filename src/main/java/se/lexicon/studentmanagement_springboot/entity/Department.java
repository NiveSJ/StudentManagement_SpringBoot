package se.lexicon.studentmanagement_springboot.entity;


import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Department {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String department_id;
    @Column(nullable = false)
    private String Name;

    @OneToMany (mappedBy = "department",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,
            CascadeType.PERSIST},fetch = FetchType.LAZY)

    private List<Course> courseList= new ArrayList<>();
   // @OneToMany(cascade = CascadeType.ALL,mappedBy = "department")  // Look at student class and refer the join column at
    // join colum of department filed
    //private List<Student> studentsList=new ArrayList<>();

    public Department() {
    }

    public Department( String name) {

        Name = name;

    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }




    //  To populate and remove student list


   // public void addStudent(Student student) {
    //    studentsList.add(student);
     //   student.setDepartment(this);
   // }

    /*public void removeStudent(Student student) {
        student.setDepartment(null);
        studentsList.remove(student);
    } */


    public void addCourse(Course course) {
        courseList.add(course);
        course.setDepartment(this);
    }

    public void removeCourse(Course course) {
        course.setDepartment(null);
        courseList.remove(course);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(department_id, that.department_id) && Objects.equals(Name, that.Name) && Objects.equals(courseList, that.courseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department_id, Name, courseList);
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id='" + department_id + '\'' +
                ", Name='" + Name + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}