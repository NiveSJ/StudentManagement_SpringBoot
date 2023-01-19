package se.lexicon.studentmanagement_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.studentmanagement_springboot.dao.ICourseDAO;
import se.lexicon.studentmanagement_springboot.dao.IDepartmentDAO;
import se.lexicon.studentmanagement_springboot.dao.IStudentDAO;
import se.lexicon.studentmanagement_springboot.entity.Course;
import se.lexicon.studentmanagement_springboot.entity.Department;
import se.lexicon.studentmanagement_springboot.entity.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class AppCommandLineRunner implements CommandLineRunner {
    @Autowired
    IStudentDAO studentDAO;
    @Autowired
    IDepartmentDAO departmentDAO;
    @Autowired
    ICourseDAO courseDAO;

    @Override
    public void run(String... args) throws Exception {
        Student student = new Student("Nive","Jay","Nive@gmail.com", LocalDate.parse("2020-01-01"));

        Department department = new Department("Computer Science and Engineering");



        Course course= new Course("System Software",4);
        Course course1= new Course("Digital Design",4);

        courseDAO.persist(course);
        courseDAO.persist(course1);

        departmentDAO.persist(department);



        student.addCourse(course);
        student.addCourse(course1);


        department.addCourse(course);
        department.addCourse(course1);

        department.addStudent(student);
        course.addStudent(student);


        studentDAO.persist(student);







    }
}
