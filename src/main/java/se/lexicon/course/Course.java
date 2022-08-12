package se.lexicon.course;

import se.lexicon.student.Student;
import se.lexicon.teacher.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {

    private int courseId;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;
    private Teacher teacher;
    private List<Lecture> lectures;
    private static int courseIdCountSequencer= 0;

    public Course() {
        courseId= ++courseIdCountSequencer;
    }

    public Course(String courseName, LocalDate startDate, int weekDuration, List<Student> students, Teacher teacher, List<Lecture> lectures) {
        this();
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = students;
        this.teacher = teacher;
        this.lectures = lectures;
    }

    public Course(String courseName, LocalDate startDate, int weekDuration, List<Student> students) {
        this();
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = students;
    }

    public int getCourseIdId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }
    public void register(Student student){
        if(students== null){
            students = new ArrayList<>();
        }
        if(students.contains(student)){
            System.out.println("This student has been registered to the course");
        }
        students.add(student);
    }
    public void unregister(Student student){
        if(students== null){
            students = new ArrayList<>();
        }
        if(students.contains(student)){
            students.remove(student);
        }
        System.out.println("This student hasn't been found in the course");
    }
    public void addLectureToCourse(Lecture lecture){
        if(lectures== null){
            students = new ArrayList<>();
        }
        if(lectures.contains(lecture)){
            System.out.println("This lecture has been added to the course");
        }
        lectures.add(lecture);
    }
    public void removeLectureFromCourse(Lecture lecture){
        if(lectures== null){
            lectures = new ArrayList<>();
        }
        if(lectures.contains(lecture)){
            lectures.remove(lecture);
        }
        System.out.println("This lecture hasn't been found in the course");
    }
    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                ", teacher=" + teacher +
                ", lectures=" + lectures +
                '}';
    }
}
