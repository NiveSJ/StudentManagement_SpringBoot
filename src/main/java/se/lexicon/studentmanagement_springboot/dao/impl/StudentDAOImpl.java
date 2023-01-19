package se.lexicon.studentmanagement_springboot.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.studentmanagement_springboot.dao.IStudentDAO;
import se.lexicon.studentmanagement_springboot.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;

@Repository
public class StudentDAOImpl implements IStudentDAO {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public Student persist(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findById(String id) {
        return Optional.ofNullable(entityManager.find(Student.class, id));
    }


    @Transactional(readOnly = true)
    public Optional<Student> findByEmail(String email) { //Mehrdad@lexicon.se
        return entityManager.createQuery("select s from Student s where UPPER(s.email) = UPPER(:e)", Student.class)
                .setParameter("e", email)
                .getResultStream()
                .findFirst();

    }


    @Transactional(readOnly = true)
    public Collection<Student> findByNameContains(String name) {
        return entityManager.createQuery("select s from Student s " +
                        "where " +
                        "UPPER(s.firstName) LIKE UPPER(CONCAT('%', :name, '%'))" +
                        " OR  " +
                        "UPPER(s.lastName) LIKE UPPER(CONCAT('%', :name, '%'))", Student.class)
                .setParameter("name", name)
                .getResultList();

    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Student> findAll() {
        return entityManager.
                createQuery("select s from Student s", Student.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public void remove(String id) {
        // ask about remove methods inside entity
        Student student = entityManager.find(Student.class, id);
        if (student == null) System.out.println("No Such Student Exception");
         entityManager.remove(student);


    }
}
