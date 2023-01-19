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
        Student student = new Student("Nive","Jay","Nive@gmail.com", LocalDate.parse("10-12-2020"));
        studentDAO.persist(student);

        Department department = new Department("Computer Science and Engineering");

        Course course= new Course("System Software",4);





    }
}
