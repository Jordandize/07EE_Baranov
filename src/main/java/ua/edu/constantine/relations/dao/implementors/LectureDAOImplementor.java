package ua.edu.constantine.relations.dao.implementors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.edu.constantine.relations.dao.LecturesDAO;
import ua.edu.constantine.relations.data.Lecture;

@Repository
@Transactional
public class LectureDAOImplementor implements LecturesDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Lecture addLecture(Lecture lecture) {
		manager.persist(lecture);
		return lecture;
	}

	@Override
	public Lecture getLecture(long id) {
		return manager.find(Lecture.class, id);
	}

	@Override
	public void saveLecture(Lecture lecture) {
		manager.merge(lecture);
	}

}
