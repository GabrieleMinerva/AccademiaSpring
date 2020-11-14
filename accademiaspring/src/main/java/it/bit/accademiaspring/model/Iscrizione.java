package it.bit.accademiaspring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="iscrizioni")
public class Iscrizione {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="valutazione_studente")
	private Integer valutazioneStudente;
	@Column(name="valutazione_corso")
	private Integer valutazioneCorso;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="id_corso")
	private Course corso;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="id_studente")
	private Student studente;
	
	public Iscrizione() {}
	public Iscrizione(Student s, Course c) {
		studente = s;
		corso = c;
	}
	public int getId() {
		return id;
	}

	public Integer getValutazioneStudente() {
		return valutazioneStudente;
	}

	public Integer getValutazioneCorso() {
		return valutazioneCorso;
	}

	public Course getCorso() {
		return corso;
	}

	public Student getStudente() {
		return studente;
	}

	public void setCorso(Course corso) {
		this.corso = corso;
	}

	public void setStudente(Student studente) {
		this.studente = studente;
	}
	
}
