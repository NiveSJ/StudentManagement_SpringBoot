package se.lexicon.studentmanagement_springboot.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.studentmanagement_springboot.dao.ICourseDAO;
import se.lexicon.studentmanagement_springboot.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CourseDAOImpl implements ICourseDAO {
    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    @Override
    public Course persist(Course course) {
        return null;
    }
    @Transactional
    @Override
    public Course findAll() {
        return null;
    }
    @Transactional
    @Override
    public Course find(String id) {
        return null;
    }
    @Transactional
    @Override
    public Course Update(Course course) {
        return null;
    }
    @Transactional
    @Override
    public void remove(String id) {

    }
}
