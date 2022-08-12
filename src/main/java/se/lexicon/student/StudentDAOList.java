package se.lexicon.student;

import se.lexicon.student.Student;
import se.lexicon.student.StudentDAO;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOList implements StudentDAO {

    private static List<Student> students;

    public StudentDAOList(List<Student>studentList) {
        students = studentList;
    }
    @Override
    public Student saveStudent(Student student) {
        if(students==null){
            students= new ArrayList<>();
        }
            for (Student s : students) {
                if (s.getEmail().equalsIgnoreCase(student.getEmail())) {
                    System.out.println("email has already existed");
                    return null;
                }
            }
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        for(Student s: students){
            if(s.getEmail().equalsIgnoreCase(email)){
                return s;
            }
        }
        throw new IllegalArgumentException("not found");
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> sameName = new ArrayList<>();
        for(Student s: students){
            if(s.getName().equalsIgnoreCase(name)){
                sameName.add(s);
            }
        }
        return sameName;
    }

    @Override
    public Student findById(int id) {
        for(Student s: students){
            if(s.getId()== id){
                return s;
            }
        }

        throw new IllegalArgumentException("not found");
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean deleteStudent(Student student) {
        if(students.contains(student)){
            students.remove(student);
            return true;
        }
        return false;
    }
}
