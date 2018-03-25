package ua.edu.constantine.relations.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "professors")
public class Professor {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "full_name", nullable = false)
	private String fullName;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable (
			joinColumns = @JoinColumn(name = "professor_fk"),
			inverseJoinColumns = @JoinColumn(name = "lecture_fk")
	)
	@OrderBy("title ASC")
	private List<Lecture> lectures;

	public Professor() {
		this("");
	}
	
	public Professor(String fullName) {
		this(-1, fullName, new ArrayList<>());
	}
	
	private Professor(long id, String fullName, List<Lecture> lectures) {
		this.id = id;
		this.fullName = fullName;
		this.lectures = lectures;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public List<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(List<Lecture> lectures) {
		this.lectures = lectures;
	}

	public String toString() {
		return id + " " + fullName;
	}
	
}
