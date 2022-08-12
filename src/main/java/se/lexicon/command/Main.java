package se.lexicon.command;

import se.lexicon.command.CommandLineUser;
import se.lexicon.command.CommandLineUserImpl;
import se.lexicon.course.Course;
import se.lexicon.course.CourseDAO;
import se.lexicon.course.CourseDAOList;
import se.lexicon.lecture.Lecture;
import se.lexicon.lecture.LectureDAO;
import se.lexicon.lecture.LectureDAOImpl;
import se.lexicon.student.Student;
import se.lexicon.student.StudentDAO;
import se.lexicon.student.StudentDAOList;
import se.lexicon.teacher.Teacher;
import se.lexicon.teacher.TeacherDAO;
import se.lexicon.teacher.TeacherDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Student> students;
    private static List<Course> courses;
    private static List<Lecture> lectures;
    private static List<Teacher> teachers;


    public static void initialize(){
        students = new ArrayList<>();
        courses= new ArrayList<>();
        lectures= new ArrayList<>();
        teachers = new ArrayList<>();
    }
    public static void main(String[] args) {
        initialize();
        CommandLineUser clu = new CommandLineUserImpl();
        StudentDAO studentDAO = new StudentDAOList(students);
        CourseDAO courseDAO = new CourseDAOList(courses);
        TeacherDAO teacherDAO= new TeacherDAOImpl();
        LectureDAO lectureDAO = new LectureDAOImpl();


        boolean isRunning = true;
        while(isRunning){
            System.out.println("Do your want to create or edit? (create/edit)");
            if(CommandLineUserImpl.getStringFromUser().equalsIgnoreCase("create")){
            System.out.println("Do you want to create student, course, teacher or lecture?(s/c/t/l)");
                if(CommandLineUserImpl.getStringFromUser().equalsIgnoreCase("s")){
                    studentDAO.saveStudent(clu.createNewStudent());
                }else if (CommandLineUserImpl.getStringFromUser().equalsIgnoreCase("c")){
                    courseDAO.saveCourse(clu.createNewCourse());
                } else if (CommandLineUserImpl.getStringFromUser().equalsIgnoreCase("t")) {
                    teacherDAO.saveTeacher(clu.createNewTeacher());
                }else {
                    lectureDAO.saveLecture(clu.createNewLecture());
                }
            }else {
                System.out.println("what do you want to edit?(student/course/teacher/lecture)");
                if(CommandLineUserImpl.getStringFromUser().equalsIgnoreCase("student")){
                    System.out.println("enter student id: ");
                    clu.editStudent(studentDAO.findById(CommandLineUserImpl.getIntFromUser()));
                }else if(CommandLineUserImpl.getStringFromUser().equalsIgnoreCase("course")){
                    System.out.println("enter course id: ");
                    clu.editCourse(courseDAO.findById(CommandLineUserImpl.getIntFromUser()));
                } else if (CommandLineUserImpl.getStringFromUser().equalsIgnoreCase("teacher")) {
                    System.out.println("enter teacher id: ");
                    clu.editTeacher(teacherDAO.findById(CommandLineUserImpl.getIntFromUser()));
                }else {
                    System.out.println("enter lecture name: ");
                    clu.editLecture(lectureDAO.findByName(CommandLineUserImpl.getStringFromUser()));
                }
            }
            System.out.println("Do you want to continue? (y/n)");
            if(CommandLineUserImpl.getStringFromUser().equalsIgnoreCase("n")){
                isRunning = false;
            }
            continue;
        }
    }
}