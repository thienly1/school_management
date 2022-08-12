package se.lexicon.student;

import se.lexicon.course.Course;

import java.util.ArrayList;
import java.util.List;

public class Student {
        private int id;
        private String name;
        private String email;
        private String address;
        private List<Course> courses;
        private static int idCountSequencer= 0;


        public Student() {
            id = ++idCountSequencer;
        }

        public Student(String name, String email, String address) {
            this();
            this.name = name;
            this.email = email;
            this.address = address;
        }

        public Student(String name, String email, String address, List<Course> courses) {
            this.name = name;
            this.email = email;
            this.address = address;
            this.courses = courses;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public List<Course> getCourses() {
            return courses;
        }

        public void setCourses(List<Course> courses) {
            this.courses = courses;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
        public List<Course> findCourseByStudentId(int studentId){
            List<Course> courseList= new ArrayList<>();
            for(Course c: courses){
                for(Student s: c.getStudents()){
                    if(s.getId() == studentId){
                        courseList.add(c);
                    }
                }
            }
            return courseList;
        }

}
