package ua.edu.constantine.relations.dao;

import ua.edu.constantine.relations.data.Professor;

public interface ProfessorDAO {

	Professor addProfessor(Professor professor);
	
	Professor getProfessor(long id);
	
	void saveProfessor(Professor professor);
	
}
