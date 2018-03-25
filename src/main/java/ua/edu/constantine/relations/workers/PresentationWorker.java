package ua.edu.constantine.relations.workers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.googlecode.ehcache.annotations.Cacheable;

import ua.edu.constantine.relations.dao.PresentationDAO;
import ua.edu.constantine.relations.data.Presentation;

@Component("presentationWorker")
public class PresentationWorker {
	
	@Autowired
	private PresentationDAO dao;
	
	public Presentation addPresentation(Presentation presentation) {
		dao.addPresentation(presentation);
		System.out.println(presentation);
		return presentation;
	}
	
	@Cacheable(cacheName = "presentationsCache")
	public Presentation getPresentation(long id) {
		Presentation presentation = dao.getPresentation(id);
		System.out.println(presentation);
		return presentation;
	}
	
	public void savePresentation(Presentation presentation) {
		dao.savePresentation(presentation);
	}

}
