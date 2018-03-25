package ua.edu.constantine.relations.dao;

import ua.edu.constantine.relations.data.Presentation;

public interface PresentationDAO {
	
	Presentation addPresentation(Presentation presentation);
	
	Presentation getPresentation(long id);
	
	void savePresentation(Presentation presentation);

}
