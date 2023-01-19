package se.lexicon.studentmanagement_springboot.dao.impl;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.studentmanagement_springboot.dao.IDepartmentDAO;
import se.lexicon.studentmanagement_springboot.entity.Department;
import se.lexicon.studentmanagement_springboot.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;
@Repository
public class DepartmentDAOImpl implements IDepartmentDAO {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    @Transactional
    public Department persist(Department department) {
        entityManager.persist(department);
        return department;
    }

    @Override
    @Transactional (readOnly = true)
    public Optional<Department> findById(String id) {
        return Optional.ofNullable(entityManager.find(Department.class,id));
    }


    @Override
    @Transactional(readOnly = true)
    public Collection<Department> findAll() {
        return entityManager.
                createQuery("select d from Department d", Department.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Department update(Department department) {
        return entityManager.merge(department);
    }

    @Override
    @Transactional
    public void remove(String id) {
        Department department = entityManager.find(Department.class, id);
        if (department == null) System.out.println("No Student found to remove");
        entityManager.remove(department);

    }
}
