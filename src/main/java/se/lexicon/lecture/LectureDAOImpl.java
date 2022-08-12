package se.lexicon.lecture;

import se.lexicon.student.Student;

import java.util.ArrayList;
import java.util.List;

public class LectureDAOImpl implements LectureDAO {
    List<Lecture> lectures;

    @Override
    public Lecture saveLecture(Lecture lecture) {
        if(!lectures.contains(lecture)){
            lectures.add(lecture);
            return lecture;
        }
        return null;
    }

    @Override
    public Lecture findByName(String name) {
        for(Lecture lecture: lectures){
            if(lecture.getLectureName().equalsIgnoreCase(name)){
                return lecture;
            }
        }
        return null;
    }

    @Override
    public List<Lecture> findAll() {
        return lectures;
    }

    @Override
    public boolean deleteLecture(Lecture lecture) {
        if(lectures.contains(lecture)){
            lectures.remove(lecture);
            return true;
        }
        return false;
    }
}
