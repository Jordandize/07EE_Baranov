package ua.edu.constantine.relations.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "presentations")
public class Presentation {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "slides_amount",nullable = false, precision = 2, scale = 0)
	private byte slidesAmount;
	
	@OneToOne(mappedBy = "presentation")
	private Lecture lecture;
	
	public Presentation() {
		this((byte)-1);
	}
	
	public Presentation(byte slidesAmount) {
		this(-1, slidesAmount, null);
	}
	
	private Presentation(long id, byte slidesAmount, Lecture lecture) {
		this.id = id;
		this.slidesAmount = slidesAmount;
		this.lecture = lecture;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte getSlidesAmount() {
		return slidesAmount;
	}

	public void setSlidesAmount(byte slidesAmount) {
		this.slidesAmount = slidesAmount;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public String toString() {
		return id + " " + slidesAmount + " | " + lecture;
	}
	
}
