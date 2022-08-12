package se.lexicon.lecture;

import se.lexicon.teacher.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Lecture {
    private String lectureName;
    private List<Teacher> teachers;

    public Lecture() {
    }

    public Lecture(String lectureName, List<Teacher> teachers) {
        this.lectureName = lectureName;
        this.teachers = teachers;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    public void addTeacherToLecture(Teacher teacher){
        if(teachers==null){
            teachers= new ArrayList<>();
        }
        if(!teachers.contains(teacher)){
            teachers.add(teacher);
        }
    }

    public void removeTeacherFromLecture(Teacher teacher){
        if(teachers==null){
            teachers= new ArrayList<>();
        }
        if(teachers.contains(teacher)){
            teachers.remove(teacher);
        }
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureName='" + lectureName + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
