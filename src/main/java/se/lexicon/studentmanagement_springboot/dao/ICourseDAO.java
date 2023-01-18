package se.lexicon.studentmanagement_springboot.dao;


import se.lexicon.studentmanagement_springboot.entity.Course;

public interface ICourseDAO  {
    Course persist (Course course);

    Course findAll();

    Course find(String id);

    Course Update(Course course);

    void remove (String id);


}
