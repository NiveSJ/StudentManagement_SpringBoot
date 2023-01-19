package se.lexicon.studentmanagement_springboot.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.studentmanagement_springboot.dao.ICourseDAO;
import se.lexicon.studentmanagement_springboot.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;

@Repository
public class CourseDAOImpl implements ICourseDAO {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Course persist(Course course) {
        entityManager.persist(course);
        return course;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> findById(String id) {
        return Optional.ofNullable(entityManager.find(Course.class,id));
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Course> findAll() {
        return entityManager.
                createQuery("select c from Course c", Course.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Course update(Course course) {
        return entityManager.merge(course);
    }

    @Override
    @Transactional
    public void remove(String id) {
        Course course = entityManager.find(Course.class, id);
        if (course == null)
            System.out.println("No Such course exception");
        entityManager.remove(course);

    }
}

