import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.lexicon.course.Course;
import se.lexicon.student.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    private Student studentTest;

    @Test
    void test_find_courses_by_studentId(){
       Student student1 = new Student();
       Student student2= new Student();
       Student student3= new Student();
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        List<Student> students1 = new ArrayList<>();
        students1.add(student1);
        students1.add(student3);
        List<Student> students2 = new ArrayList<>();
        students2.add(student2);
        students2.add(student3);

        Course course1 = new Course();
        course1.setStudents(students);
        Course course2 = new Course();
        course2.setStudents(students1);
        Course course3 = new Course();
        course3.setStudents(students2);
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        List<Course> coursesTest = new ArrayList<>();
        coursesTest.add(course1);
        coursesTest.add(course2);
        studentTest= new Student();
        studentTest.setCourses(courses);

        Assertions.assertEquals(studentTest.findCourseByStudentId(1), coursesTest);
    }


}
