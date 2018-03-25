package ua.edu.constantine.relations.workers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.googlecode.ehcache.annotations.Cacheable;

import ua.edu.constantine.relations.dao.LecturesDAO;
import ua.edu.constantine.relations.data.Lecture;

@Component("lectureWorker")
public class LectureWorker {
	
	@Autowired
	private LecturesDAO dao;
	
	public Lecture addLecture(Lecture lecture) {
		lecture = dao.addLecture(lecture);
		System.out.println(lecture);
		return lecture;
	}
	
	@Cacheable(cacheName = "lecturesCache")
	public Lecture getLecture(long id) {
		Lecture lecture = dao.getLecture(id);
		System.out.println(lecture);
		return lecture;
	}
	
	public void saveLecture(Lecture lecture) {
		dao.saveLecture(lecture);
	}

}
