package se.lexicon.teacher;

import se.lexicon.teacher.Teacher;
import se.lexicon.teacher.TeacherDAO;

import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements TeacherDAO {
    private List<Teacher> teachers;
    @Override
    public Teacher saveTeacher(Teacher teacher) {
        if(teachers==null){
            teachers= new ArrayList<>();
        }
        for(Teacher t: teachers){
            if(!t.getEmail().equalsIgnoreCase(teacher.getEmail())){
                teachers.add(teacher);
                return teacher;
            }
        }
        return null;
    }

    @Override
    public Teacher findByEmail(String email) {
        if(teachers==null){
            teachers= new ArrayList<>();
        }
        for(Teacher t: teachers){
            if(t.getEmail().equalsIgnoreCase(email)){
                return t;
            }
        }

        return null;
    }

    @Override
    public List<Teacher> findByName(String name) {
        List<Teacher> teachers1 = new ArrayList<>();
        if(teachers==null){
            teachers= new ArrayList<>();
        }
        for(Teacher t:teachers){
            if(t.getName().equalsIgnoreCase(name)){
                teachers1.add(t);
            }
        }
        return teachers1;
    }

    @Override
    public Teacher findById(int teacherId) {
        if(teachers==null){
            teachers= new ArrayList<>();
        }
        for(Teacher t: teachers){
            if(t.getTeacherId()==teacherId){
                return t;
            }
        }

        return null;
    }

    @Override
    public List<Teacher> findAll() {
        if(teachers==null){
            teachers= new ArrayList<>();
        }
        return teachers;
    }

    @Override
    public boolean deleteTeacher(Teacher teacher) {
        if(teachers==null){
            teachers= new ArrayList<>();
        }
        if(teachers.contains(teacher)){
            teachers.remove(teacher);
            return true;
        }
        return false;
    }
}
