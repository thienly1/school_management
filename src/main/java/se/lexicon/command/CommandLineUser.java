package se.lexicon.command;

import se.lexicon.course.Course;
import se.lexicon.lecture.Lecture;
import se.lexicon.student.Student;
import se.lexicon.teacher.Teacher;

public interface CommandLineUser {
    Student createNewStudent();
    Course createNewCourse();
    Teacher createNewTeacher();
    Lecture createNewLecture();
    // Student findById(Course course, int studentId);
    // Student findByEmail(Course course, String email);
    //List<Student> findAll(Course course);
    //List<Student> findByName(Course course,String name);
    Student editStudent(Student student);
    Course editCourse(Course course);
    Teacher editTeacher(Teacher teacher);
    Lecture editLecture(Lecture lecture);


}
