 package ua.edu.constantine.relations;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import ua.edu.constantine.relations.data.Lecture;
import ua.edu.constantine.relations.data.Presentation;
import ua.edu.constantine.relations.data.Professor;
import ua.edu.constantine.relations.enums.Faculty;
import ua.edu.constantine.relations.workers.LectureWorker;
import ua.edu.constantine.relations.workers.PresentationWorker;
import ua.edu.constantine.relations.workers.ProfessorWorker;

@Component
public class Main {

	private static LectureWorker lectureWorker;
	private static ProfessorWorker professorWorker;
	private static PresentationWorker presentationWorker;
	
	public static void main(String[] args) {
		@SuppressWarnings({ "resource", "unused" })
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		
		try {
			Presentation presentation = new Presentation((byte) 65);
			presentationWorker.addPresentation(presentation);
			Presentation presentation2 = new Presentation((byte) 99);
			presentationWorker.addPresentation(presentation2);
			
			Lecture lecture = new Lecture();
			lecture.setTitle("Java in 2018");
			lecture.setCredits(3.0);
			lecture.setFaculty(Faculty.FI);
			String[] themes = new String[] { "Java", "Java EE", "Spring", "DB", "JPA", "Hibernate" };
			lecture.setThemes(Arrays.asList(themes));
			lecture.setPresentation(presentation);
			lectureWorker.addLecture(lecture);
			
			Lecture lecture2 = new Lecture();
			lecture2.setTitle("C++ in 2018");
			lecture2.setCredits(3.0);
			lecture2.setFaculty(Faculty.FI);
			String[] themes2 = new String[] { "No Java", "No Java EE", "std", "cout", "math", "shot" };
			lecture2.setThemes(Arrays.asList(themes2));
			lecture2.setPresentation(presentation2);
			lectureWorker.addLecture(lecture2);
			
			Professor professor = new Professor();
			professor.setFullName("Jorah Baron Blacktorn");
			Lecture[] lectures = new Lecture[] { lecture, lecture2 };
			professor.setLectures(Arrays.asList(lectures));
			professorWorker.addProfessor(professor);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("↑ERRO↓");
		}
	}

	@Autowired
	@Qualifier("professorWorker")
	public void setProfessorWorker(ProfessorWorker professorWorker) {
		Main.professorWorker = professorWorker;
	}

	@Autowired
	@Qualifier("lectureWorker")
	public void setLectureWorker(LectureWorker lectureWorker) {
		Main.lectureWorker = lectureWorker;
	}
	
	@Autowired
	@Qualifier("presentationWorker")
	public void setPresentationWorker(PresentationWorker presentationWorker) {
		Main.presentationWorker = presentationWorker;
	}
	
}
