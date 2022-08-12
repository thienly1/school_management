package se.lexicon.course;

import se.lexicon.course.Course;
import se.lexicon.course.CourseDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOList implements CourseDAO {

    private static List<Course> courses;

    public CourseDAOList(List<Course> courseList) {
        courses = courseList;
    }

    @Override
    public Course saveCourse(Course course) {
        if(courses.contains(course)){
            System.out.println("course has existed already");
            return null;
        }
        courses.add(course);
        return course;
    }
    @Override
    public Course findById(int id) {
        for(Course c: courses){
            if(c.getCourseIdId()== id){
                return c;
            }
        }
        throw new IllegalArgumentException("not found");
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> sameNameCourses = new ArrayList<>();
        for(Course c:courses){
            if(c.getCourseName().equalsIgnoreCase(name)){
                sameNameCourses.add(c);
            }
        }
        return sameNameCourses;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        List<Course> sameDateCourses = new ArrayList<>();
        for(Course c:courses){
            if(c.getStartDate().isEqual(date)){
                sameDateCourses.add(c);
            }
        }
        return sameDateCourses;
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public boolean removeCourse(Course course) {
       if(courses.contains(course)){
           courses.remove(course);
           return true;
       }
       return false;
    }
}
