package se.lexicon.command;

import se.lexicon.course.Course;
import se.lexicon.lecture.Lecture;
import se.lexicon.student.Student;
import se.lexicon.teacher.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CommandLineUserImpl implements CommandLineUser {
    static Scanner scanner= new Scanner(System.in);
    static String getStringFromUser(){
        return scanner.nextLine();
    }
    static int getIntFromUser() {
        return Integer.parseInt(scanner.nextLine());
    }
    @Override
    public Student createNewStudent() {
        Student student = new Student();
        System.out.println("set student's name");
        student.setName(getStringFromUser());
        System.out.println("set student's email");
        student.setEmail(getStringFromUser());
        System.out.println("set student's address");
        student.setAddress(getStringFromUser());
        System.out.println(student);
        return student;
    }
    @Override
    public Course createNewCourse() {
        Course course = new Course();
        List<Student>students = new ArrayList<>();
        System.out.println("set course's name");
        course.setCourseName(getStringFromUser());
        System.out.println("set course's start date, default form: yyyy-mm-dd");
        course.setStartDate(LocalDate.parse(getStringFromUser()));
        System.out.println("set course's week duration");
        course.setWeekDuration(getIntFromUser());
        course.setStudents(students);
        System.out.println(course);
        return course;
    }

    @Override
    public Teacher createNewTeacher() {
        Teacher teacher = new Teacher();
        System.out.print("set Teacher's name: ");
        teacher.setName(getStringFromUser());
        System.out.print("set teacher's email: ");
        teacher.setEmail(getStringFromUser());
        System.out.print("set teacher's address: ");
        teacher.setAddress(getStringFromUser());
        System.out.println(teacher);
        return teacher;
    }

    @Override
    public Lecture createNewLecture() {
        Lecture lecture = new Lecture();
        System.out.print("set lecture's name: ");
        lecture.setLectureName(getStringFromUser());
        List<Teacher> teachers = new ArrayList<>();
        return lecture;
    }

    @Override
    public Teacher editTeacher(Teacher teacher) {
        boolean isEdit = true;
        while(isEdit) {
            System.out.println("what do you want to edit with the teacher: " + teacher+ "? (name, email, or address)");
            String a = getStringFromUser();
            if (a.equalsIgnoreCase("name")) {
                System.out.println("Pls enter the new name");
                teacher.setName(getStringFromUser());
            } else if (a.equalsIgnoreCase("email")) {
                System.out.println("Pls enter new email");
                teacher.setEmail(getStringFromUser());
            } else {
                System.out.println("Pls enter new address");
                teacher.setAddress(getStringFromUser());
            }
            System.out.println("do you want to edit more? (y/n)");
            String b = getStringFromUser();
            if (b.equalsIgnoreCase("n")) {
                isEdit = false;
            }
        }
        return teacher;
    }

    @Override
    public Lecture editLecture(Lecture lecture) {
        System.out.print("do you want to edit name of lecture? (y/n)");
        if(getStringFromUser().equalsIgnoreCase("y")){
            System.out.print("enter new name: ");
            lecture.setLectureName(getStringFromUser());
        }
        return lecture;
    }
    @Override
    public Student editStudent(Student student) {
        boolean isEdit = true;
        while(isEdit) {
            System.out.println("what do you want to edit with the student: " + student+ "? (name, email, or address)");
            String a = getStringFromUser();
            if (a.equalsIgnoreCase("name")) {
                System.out.println("Pls enter the new name");
                student.setName(getStringFromUser());
            } else if (a.equalsIgnoreCase("email")) {
                System.out.println("Pls enter new email");
                student.setEmail(getStringFromUser());
            } else {
                System.out.println("Pls enter new address");
                student.setAddress(getStringFromUser());
            }
            System.out.println("do you want to edit more? (y/n)");
            String b = getStringFromUser();
            if (b.equalsIgnoreCase("n")) {
                isEdit = false;
            }
        }
        return student;
    }

    @Override
    public Course editCourse(Course course) {
        boolean isEdit = true;
        while(isEdit) {
            System.out.println("what do you want to edit in the course: " + course + "? (name, start date, or week duration)");
            String a = getStringFromUser();
            if (a.equalsIgnoreCase("name")) {
                System.out.println("Pls enter the new name");
                course.setCourseName(getStringFromUser());
            } else if (a.equalsIgnoreCase("start date")) {
                System.out.println("Pls enter new start date, default form: yyyy-mm-dd");
                course.setStartDate(LocalDate.parse(getStringFromUser()));
            } else {
                System.out.println("Pls enter new week duration");
                course.setWeekDuration(getIntFromUser());
            }
            System.out.println("do you want to edit more? (y/n)");
            String b = getStringFromUser();
            if (b.equalsIgnoreCase("n")) {
                isEdit = false;
            }
        }
        return course;
    }
}
