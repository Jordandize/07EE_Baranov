package ua.edu.constantine.relations.workers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.googlecode.ehcache.annotations.Cacheable;

import ua.edu.constantine.relations.dao.ProfessorDAO;
import ua.edu.constantine.relations.data.Professor;

@Component("professorWorker")
public class ProfessorWorker {
	
	@Autowired()
	private ProfessorDAO dao;
	
	public Professor addProfessor(Professor professor) {
		professor = dao.addProfessor(professor);
		System.out.println(professor);
		return professor;
	}
	
	@Cacheable(cacheName = "professorsCache")
	public Professor getProfessor(long id) {
		Professor professor = dao.getProfessor(id);
		System.out.println(professor);
		return professor;
	}
	
	public void saveProfessor(Professor professor) {
		dao.saveProfessor(professor);
	}

}
