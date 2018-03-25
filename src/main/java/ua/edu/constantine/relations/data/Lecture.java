package ua.edu.constantine.relations.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import ua.edu.constantine.relations.enums.Faculty;

@Entity
@Access(AccessType.FIELD)
@Table(name = "lectures")
public class Lecture {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(precision = 3, scale = 1, nullable = false)
	private double credits;
	
	@Column(name = "faculty", nullable = false)
	@Enumerated(EnumType.STRING)
	private Faculty faculty;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = " LectureThemes")
	@Column(name = "themes", nullable = false)
	private List<String> themes = new ArrayList<>();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "presentation_fk", nullable = true)
	private Presentation presentation;
	
	@ManyToMany(mappedBy = "lectures", fetch = FetchType.LAZY)
	@OrderBy("fullName ASC")
	private List<Professor> professors;
	
	public Lecture() {
		this("", -1.0, Faculty.NO_FACULTY, new ArrayList<>());
	}
	
	public Lecture(String title, double credits, Faculty faculty, List<String> themes) {
		this(-1, title, credits, faculty, themes, null);
	}
	
	private Lecture(long id, String title, double credits, Faculty faculty, List<String> themes, Presentation presentation) {
		this.id = id;
		this.title = title;
		this.credits = credits;
		this.faculty = faculty;
		this.themes = themes;
		this.presentation = presentation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public List<String> getThemes() {
		return themes;
	}

	public void setThemes(List<String> themes) {
		this.themes = themes;
	}

	public Presentation getPresentation() {
		return presentation;
	}

	public void setPresentation(Presentation presentation) {
		this.presentation = presentation;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public String toString() {
		return "[" + id + "] " + title + " → " + credits + " → " + faculty + " → " + themes  + " → " + presentation;
	}

}
