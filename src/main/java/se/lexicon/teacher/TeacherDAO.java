package se.lexicon.teacher;

import se.lexicon.teacher.Teacher;

import java.util.List;

public interface TeacherDAO {
    Teacher saveTeacher(Teacher teacher);
    Teacher findByEmail(String email);
    List<Teacher> findByName(String name);
    Teacher findById(int teacherId);
    List<Teacher> findAll();
    boolean deleteTeacher(Teacher teacher);
}
