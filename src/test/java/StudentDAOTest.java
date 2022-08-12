import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.student.Student;
import se.lexicon.student.StudentDAO;
import se.lexicon.student.StudentDAOList;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOTest {
    private StudentDAO testObject;
    private List<Student>students;
    private Student student1;
    private Student student2;
    @BeforeEach
    void unit(){
        student1 = new Student("ly","ly@mail.com", "växjö");
        student2 = new Student("Lan", "lan@mail.com", "Växjö");
        students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        testObject = new StudentDAOList(students);
    }

    @Test
    void test_save_student_successfully(){
        Student student3= new Student("Le", "le@mail.com", "växjö");
        List<Student> studentList = new ArrayList<>();
        studentList.addAll(students);
        studentList.add(student3);
        Assertions.assertEquals(testObject.saveStudent(student3),student3);
    }
    @Test
    void test_save_student_return_null(){
        Student student3= new Student("Le", "ly@mail.com", "växjö");
        List<Student> studentList = new ArrayList<>();
        studentList.addAll(students);
        studentList.add(student3);
        Assertions.assertEquals(testObject.saveStudent(student3),null);
    }
    @Test
    void test_find_by_mail_return_student() {
        Assertions.assertEquals(testObject.findByEmail("ly@mail.com"), student1);
    }
    @Test
    void test_find_by_mail_throw_illegalException() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->testObject.findByEmail("le@mail.com"));
    }
    @Test
    void test_find_by_name(){
        Student student3= new Student("LY", "ly@mail.com", "växjö");
        students.add(student3);
        List<Student> studentList = new ArrayList<>();
        studentList.add( student1);
        studentList.add(student3);
        Assertions.assertEquals(testObject.findByName("ly"),studentList );
    }
    @Test
    void test_delete_student_successfully(){
        Assertions.assertTrue(testObject.deleteStudent(student1));
    }
    @Test
    void test_delete_student_return_false(){
        Student student3= new Student("LY", "ly@mail.com", "växjö");
        Assertions.assertFalse(testObject.deleteStudent(student3));
    }



}
