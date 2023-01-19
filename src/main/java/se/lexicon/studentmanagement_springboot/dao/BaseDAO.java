package se.lexicon.studentmanagement_springboot.dao;

import se.lexicon.studentmanagement_springboot.entity.Student;

import java.util.Collection;
import java.util.Optional;

public interface BaseDAO<T,U> {

    T persist(T t);
    Optional<T> findById(U u);

    Collection<T> findAll();
    T update(T t);
    void remove(U u);


}
