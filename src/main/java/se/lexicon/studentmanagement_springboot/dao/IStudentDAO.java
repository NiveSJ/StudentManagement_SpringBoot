package se.lexicon.studentmanagement_springboot.dao;

import se.lexicon.studentmanagement_springboot.entity.Student;

import java.util.Collection;
import java.util.Optional;

public interface IStudentDAO extends BaseDAO<Student,String> {
    Student persist(Student student);
    Optional<Student> findById(String id);
    Optional<Student> findByEmail(String email);
    Collection<Student> findByNameContains(String name);
    Collection<Student> findAll();
    Student update(Student student);
    void remove(String id);
}
