package se.lexicon.course;

import se.lexicon.course.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseDAO {

    Course saveCourse(Course course);
    Course findById( int id);
    List<Course> findByName (String name);
    List<Course> findByDate(LocalDate date);
    List<Course> findAll();
    boolean removeCourse(Course course);


}
