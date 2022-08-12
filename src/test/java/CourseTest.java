import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.course.Course;
import se.lexicon.student.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseTest {
    Student student1;
    Student student2;
    List <Student> students;

    private Course courseTest;
    @BeforeEach
    void test_unit(){
        student1 = new Student();
        student2= new Student();
        students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        courseTest = new Course();
        courseTest.setStudents(students);
    }
    @Test
    void Test_register_student_to_course_successfully(){
        Student student= new Student();
        List <Student> studentList= new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student);
        courseTest.register(student);
        Assertions.assertEquals(courseTest.getStudents(), studentList);
    }
    @Test
    void Test_register_student_to_course_unsuccessfully(){
        courseTest.register(student1);
        Assertions.assertEquals(courseTest.getStudents(), students);
    }

}
