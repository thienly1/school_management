package se.lexicon.lecture;

import se.lexicon.student.Student;

import java.util.List;

public interface LectureDAO {
    Lecture saveLecture(Lecture lecture);
    Lecture findByName(String name);
    List<Lecture> findAll();
    boolean deleteLecture(Lecture lecture);

}
