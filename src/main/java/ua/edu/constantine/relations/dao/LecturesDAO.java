package ua.edu.constantine.relations.dao;

import ua.edu.constantine.relations.data.Lecture;

public interface LecturesDAO {
	
	Lecture addLecture(Lecture lecture);
	
	Lecture getLecture(long id);
	
	void saveLecture(Lecture lecture);
	
}
