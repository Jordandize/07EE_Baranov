package ua.edu.constantine.relations.dao.implementors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.edu.constantine.relations.dao.ProfessorDAO;
import ua.edu.constantine.relations.data.Professor;

@Repository
@Transactional
public class ProfessorDAOImplementor implements ProfessorDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Professor addProfessor(Professor professor) {
		manager.persist(professor);
		return professor;
	}

	@Override
	public Professor getProfessor(long id) {
		return manager.find(Professor.class, id);
	}

	@Override
	public void saveProfessor(Professor professor) {
		manager.merge(professor);
	}

}
