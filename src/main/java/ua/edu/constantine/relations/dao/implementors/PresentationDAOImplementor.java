package ua.edu.constantine.relations.dao.implementors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.edu.constantine.relations.dao.PresentationDAO;
import ua.edu.constantine.relations.data.Presentation;

@Repository
@Transactional
public class PresentationDAOImplementor implements PresentationDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Presentation addPresentation(Presentation presentation) {
		manager.persist(presentation);
		return presentation;
	}

	@Override
	public Presentation getPresentation(long id) {
		return manager.find(Presentation.class, id);
	}

	@Override
	public void savePresentation(Presentation presentation) {
		manager.merge(presentation);
	}

}
