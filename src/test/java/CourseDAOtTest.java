import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.course.Course;
import se.lexicon.course.CourseDAO;
import se.lexicon.course.CourseDAOList;
import se.lexicon.student.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOtTest {
    private static List<Course> courses;
    private  Course course1;
    private Course course2;
    private CourseDAO testObject;
    private List<Student>students1;
    private List<Student>students2;
    private Student student1;
    private Student student2;
    private Student student3;

    @BeforeEach
    void unit(){
        student1 = new Student("ly","ly@mail.com", "växjö");
        student2 = new Student("Lan", "lan@mail.com", "Växjö");
        student3 = new Student("Le", "le@mail.com", "Växjö");
        students1 = new ArrayList<>();
        students1.add(student1);
        students1.add(student2);
        students2 = new ArrayList<>();
        students2.add(student1);
        students2.add(student3);
        course1 = new Course("Java", LocalDate.of(2022,9,20),4, students1);
        course2 = new Course("Python", LocalDate.of(2022,11,15), 4, students2);
        courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        testObject = new CourseDAOList(courses);
    }
    @Test
    void test_save_course_successfully(){
        Course course = new Course("JavaScript", LocalDate.of(2022,12,1), 4, students1);
        Assertions.assertEquals(testObject.saveCourse(course), course);
    }
    @Test
    void test_save_course_return_null(){
               Assertions.assertEquals(testObject.saveCourse(course1), null);
    }
    @Test
    void test_find_by_id_successfully(){
        Assertions.assertEquals(testObject.findById(1), course1);
    }
    @Test
    @DisplayName("we couldn't found the course with IdCourse as your searching")
    void test_find_by_id_return_IllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> testObject.findById(3));
    }
    @Test
    void test_find_by_name_successfully() {
        List<Course> coursesTest= new ArrayList<>();
        coursesTest.add(course1);
        Assertions.assertEquals(testObject.findByName("JAVA"), coursesTest);
    }
    @Test
    void test_find_by_date_successfully() {
        List<Course> coursesTest= new ArrayList<>();
        coursesTest.add(course2);
        Assertions.assertEquals(testObject.findByDate(LocalDate.of(2022,11,15)), coursesTest);
    }
    @Test
    void test_remove_course_successfully() {
        Assertions.assertTrue(testObject.removeCourse(course1));
    }
    @Test
    void test_remove_course_return_false() {
        Course course = new Course("JavaScript", LocalDate.of(2022,12,1), 4, students1);
        Assertions.assertFalse(testObject.removeCourse(course));
    }
}
